package com.smartautoclicker.app.automation

data class WorkflowSnapshot(

    val workflowId: String,

    val stepIndex: Int,

    val executionState: ExecutionState,

    val variables: Map<String, String>,

    val timestamp: Long = System.currentTimeMillis()

)
