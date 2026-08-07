package com.smartautoclicker.app.automation

data class WorkflowMetrics(

    var runs: Int = 0,

    var successes: Int = 0,

    var failures: Int = 0,

    var totalExecutionTime: Long = 0L

) {

    fun recordSuccess(duration: Long) {
        runs++
        successes++
        totalExecutionTime += duration
    }

    fun recordFailure(duration: Long) {
        runs++
        failures++
        totalExecutionTime += duration
    }

    fun averageExecutionTime(): Long {

        if (runs == 0) {
            return 0L
        }

        return totalExecutionTime / runs
    }

    fun successRate(): Float {

        if (runs == 0) {
            return 0f
        }

        return (successes.toFloat() / runs.toFloat()) * 100f
    }

    fun reset() {
        runs = 0
        successes = 0
        failures = 0
        totalExecutionTime = 0L
    }
}
