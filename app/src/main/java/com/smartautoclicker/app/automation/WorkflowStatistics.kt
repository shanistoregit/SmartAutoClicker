package com.smartautoclicker.app.automation

data class WorkflowStatistics(

    val workflowId: String,

    var runCount: Int = 0,

    var successCount: Int = 0,

    var failureCount: Int = 0,

    var totalExecutionTime: Long = 0L

) {

    fun recordSuccess(duration: Long) {
        runCount++
        successCount++
        totalExecutionTime += duration
    }

    fun recordFailure(duration: Long) {
        runCount++
        failureCount++
        totalExecutionTime += duration
    }

    fun averageExecutionTime(): Long {

        if (runCount == 0) {
            return 0L
        }

        return totalExecutionTime / runCount
    }

    fun successRate(): Float {

        if (runCount == 0) {
            return 0f
        }

        return (successCount.toFloat() / runCount.toFloat()) * 100f
    }

    fun reset() {
        runCount = 0
        successCount = 0
        failureCount = 0
        totalExecutionTime = 0L
    }
}
