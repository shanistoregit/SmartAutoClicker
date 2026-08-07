package com.smartautoclicker.app.automation

object ErrorHandler {

    data class ErrorInfo(
        val message: String,
        val throwable: Throwable? = null,
        val timestamp: Long = System.currentTimeMillis()
    )

    private val errors = mutableListOf<ErrorInfo>()

    fun report(
        message: String,
        throwable: Throwable? = null
    ) {

        synchronized(errors) {

            errors.add(
                ErrorInfo(
                    message = message,
                    throwable = throwable
                )
            )

            if (errors.size > 200) {
                errors.removeAt(0)
            }
        }

        AutomationLogger.e(
            message,
            throwable ?: Exception(message)
        )
    }

    fun latest(): ErrorInfo? {

        synchronized(errors) {
            return errors.lastOrNull()
        }
    }

    fun all(): List<ErrorInfo> {

        synchronized(errors) {
            return errors.toList()
        }
    }

    fun count(): Int {

        synchronized(errors) {
            return errors.size
        }
    }

    fun clear() {

        synchronized(errors) {
            errors.clear()
        }
    }

    fun hasErrors(): Boolean {

        synchronized(errors) {
            return errors.isNotEmpty()
        }
    }
}
