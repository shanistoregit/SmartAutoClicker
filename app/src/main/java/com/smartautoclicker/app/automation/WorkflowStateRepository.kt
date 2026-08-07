package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object WorkflowStateRepository {

    private val states =
        ConcurrentHashMap<String, WorkflowState>()

    fun put(state: WorkflowState) {
        states[state.workflowId] = state
    }

    fun get(workflowId: String): WorkflowState? {
        return states[workflowId]
    }

    fun remove(workflowId: String) {
        states.remove(workflowId)
    }

    fun contains(workflowId: String): Boolean {
        return states.containsKey(workflowId)
    }

    fun all(): List<WorkflowState> {
        return states.values.toList()
    }

    fun clear() {
        states.clear()
    }

    fun count(): Int {
        return states.size
    }
}
