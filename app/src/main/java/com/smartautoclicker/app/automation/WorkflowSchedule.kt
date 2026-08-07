package com.smartautoclicker.app.automation

data class WorkflowSchedule(

    val workflowId: String,

    var enabled: Boolean = true,

    var intervalMillis: Long = 0L,

    var nextRun: Long = 0L,

    var priority: WorkflowPriority =
        WorkflowPriority.NORMAL

) {

    fun scheduleNext() {

        if (intervalMillis > 0) {
            nextRun =
                System.currentTimeMillis() + intervalMillis
        }
    }

    fun isReady(): Boolean {

        if (!enabled) {
            return false
        }

        return System.currentTimeMillis() >= nextRun
    }
}
