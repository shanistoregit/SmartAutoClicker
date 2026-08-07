package com.smartautoclicker.app.automation

data class WorkflowEvent(

    val workflowId: String,

    val stepId: String = "",

    val type: EventType,

    val timestamp: Long = System.currentTimeMillis(),

    val message: String = ""

) {

    enum class EventType {
        WORKFLOW_STARTED,
        WORKFLOW_STOPPED,
        STEP_STARTED,
        STEP_COMPLETED,
        STEP_SKIPPED,
        STEP_FAILED,
        WORKFLOW_COMPLETED,
        WORKFLOW_FAILED
    }
}
