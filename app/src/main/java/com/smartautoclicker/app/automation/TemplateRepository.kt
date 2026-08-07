package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object TemplateRepository {

    private val templates =
        ConcurrentHashMap<String, WorkflowTemplate>()

    fun add(template: WorkflowTemplate) {
        templates[template.id] = template
    }

    fun remove(id: String) {
        templates.remove(id)
    }

    fun get(id: String): WorkflowTemplate? {
        return templates[id]
    }

    fun getAll(): List<WorkflowTemplate> {
        return templates.values.sortedBy { it.name }
    }

    fun exists(id: String): Boolean {
        return templates.containsKey(id)
    }

    fun clear() {
        templates.clear()
    }

    fun size(): Int {
        return templates.size
    }
}
