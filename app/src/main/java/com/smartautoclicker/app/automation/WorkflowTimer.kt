package com.smartautoclicker.app.automation

class WorkflowTimer {

    private var startedAt = 0L

    fun start() {
        startedAt = System.currentTimeMillis()
    }

    fun restart() {
        start()
    }

    fun elapsed(): Long {
        if (startedAt == 0L) {
            return 0L
        }

        return System.currentTimeMillis() - startedAt
    }

    fun hasElapsed(milliseconds: Long): Boolean {
        return elapsed() >= milliseconds
    }

    fun reset() {
        startedAt = 0L
    }

    fun isRunning(): Boolean {
        return startedAt != 0L
    }
}
