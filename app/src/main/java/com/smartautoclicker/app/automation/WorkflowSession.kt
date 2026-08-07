package com.smartautoclicker.app.automation

import java.util.UUID

data class WorkflowSession(

    val sessionId: String = UUID.randomUUID().toString(),

    val workflowId: String,

    val startedAt: Long = System.currentTimeMillis(),

    var finishedAt: Long = 0L,

    var state: ExecutionState = ExecutionState.IDLE

) {

    fun finish(state: ExecutionState) {
        this.state = state
        this.finishedAt = System.currentTimeMillis()
    }

    fun duration(): Long {

        if (finishedAt == 0L) {
            return System.currentTimeMillis() - startedAt
        }

        return finishedAt - startedAt
    }
}
