package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object WorkflowRepository {

    private val workflows =
        ConcurrentHashMap<String, Workflow>()

    fun add(workflow: Workflow): Boolean {

        if (workflow.id.isBlank()) {
            return false
        }

        workflows[workflow.id] = workflow
        return true
    }

    fun update(workflow: Workflow): Boolean {

        if (!workflows.containsKey(workflow.id)) {
            return false
        }

        workflows[workflow.id] = workflow
        return true
    }

    fun remove(id: String): Boolean {
        return workflows.remove(id) != null
    }

    fun get(id: String): Workflow? {
        return workflows[id]
    }

    fun exists(id: String): Boolean {
        return workflows.containsKey(id)
    }

    fun getAll(): List<Workflow> {
        return workflows.values.sortedBy { it.name }
    }

    fun clear() {
        workflows.clear()
    }

    fun count(): Int {
        return workflows.size
    }
}
