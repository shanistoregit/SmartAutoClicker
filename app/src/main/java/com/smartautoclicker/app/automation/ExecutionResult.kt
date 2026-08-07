package com.smartautoclicker.app.automation

data class ExecutionResult(

    val success: Boolean,

    val workflowId: String = "",

    val completedSteps: Int = 0,

    val totalSteps: Int = 0,

    val message: String = "",

    val error: String? = null,

    val startedAt: Long = 0L,

    val finishedAt: Long = 0L

) {

    fun duration(): Long {

        if (startedAt == 0L || finishedAt == 0L) {
            return 0L
        }

        return finishedAt - startedAt
    }

    fun progress(): Float {

        if (totalSteps <= 0) {
            return 0f
        }

        return completedSteps.toFloat() / totalSteps.toFloat()
    }

    fun hasError(): Boolean {
        return !error.isNullOrBlank()
    }

    companion object {

        fun success(
            workflowId: String,
            completedSteps: Int,
            totalSteps: Int,
            startedAt: Long,
            finishedAt: Long
        ): ExecutionResult {

            return ExecutionResult(
                success = true,
                workflowId = workflowId,
                completedSteps = completedSteps,
                totalSteps = totalSteps,
                message = "Workflow completed successfully.",
                startedAt = startedAt,
                finishedAt = finishedAt
            )
        }

        fun failure(
            workflowId: String,
            completedSteps: Int,
            totalSteps: Int,
            error: String,
            startedAt: Long,
            finishedAt: Long
        ): ExecutionResult {

            return ExecutionResult(
                success = false,
                workflowId = workflowId,
                completedSteps = completedSteps,
                totalSteps = totalSteps,
                message = "Workflow execution failed.",
                error = error,
                startedAt = startedAt,
                finishedAt = finishedAt
            )
        }
    }
}
