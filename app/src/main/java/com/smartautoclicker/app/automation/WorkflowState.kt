package com.smartautoclicker.app.automation

data class WorkflowState(

    val workflowId: String,

    var currentStep: Int = 0,

    var state: ExecutionState = ExecutionState.IDLE,

    var lastUpdated: Long = System.currentTimeMillis()

) {

    fun updateState(newState: ExecutionState) {
        state = newState
        lastUpdated = System.currentTimeMillis()
    }

    fun nextStep() {
        currentStep++
        lastUpdated = System.currentTimeMillis()
    }

    fun reset() {
        currentStep = 0
        state = ExecutionState.IDLE
        lastUpdated = System.currentTimeMillis()
    }
}
