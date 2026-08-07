package com.smartautoclicker.app.automation

data class AutomationStatistics(

    var workflowsStarted: Int = 0,

    var workflowsCompleted: Int = 0,

    var totalStepsExecuted: Int = 0,

    var totalErrors: Int = 0,

    var lastStartTime: Long = 0L,

    var lastFinishTime: Long = 0L,

    var lastErrorMessage: String = ""

) {

    fun workflowStarted() {
        workflowsStarted++
        lastStartTime = System.currentTimeMillis()
    }

    fun workflowCompleted() {
        workflowsCompleted++
        lastFinishTime = System.currentTimeMillis()
    }

    fun stepExecuted() {
        totalStepsExecuted++
    }

    fun error(message: String) {
        totalErrors++
        lastErrorMessage = message
    }

    fun reset() {
        workflowsStarted = 0
        workflowsCompleted = 0
        totalStepsExecuted = 0
        totalErrors = 0
        lastStartTime = 0L
        lastFinishTime = 0L
        lastErrorMessage = ""
    }

    fun successRate(): Float {

        if (workflowsStarted == 0) {
            return 0f
        }

        return (workflowsCompleted.toFloat() / workflowsStarted.toFloat()) * 100f
    }

    fun executionTime(): Long {

        if (lastStartTime == 0L || lastFinishTime == 0L) {
            return 0L
        }

        return lastFinishTime - lastStartTime
    }
}
