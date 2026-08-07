package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object CategoryRepository {

    private val categories =
        ConcurrentHashMap<String, WorkflowCategory>()

    fun add(category: WorkflowCategory) {
        categories[category.id] = category
    }

    fun remove(id: String) {
        categories.remove(id)
    }

    fun get(id: String): WorkflowCategory? {
        return categories[id]
    }

    fun getAll(): List<WorkflowCategory> {
        return categories.values.sortedBy { it.name }
    }

    fun exists(id: String): Boolean {
        return categories.containsKey(id)
    }

    fun clear() {
        categories.clear()
    }

    fun size(): Int {
        return categories.size
    }
}
