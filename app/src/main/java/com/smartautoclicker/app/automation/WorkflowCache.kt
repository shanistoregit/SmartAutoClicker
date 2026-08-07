package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object WorkflowCache {

    private val cache =
        ConcurrentHashMap<String, Workflow>()

    fun put(workflow: Workflow) {

        if (workflow.id.isBlank()) {
            return
        }

        cache[workflow.id] = workflow
    }

    fun get(id: String): Workflow? {
        return cache[id]
    }

    fun contains(id: String): Boolean {
        return cache.containsKey(id)
    }

    fun remove(id: String) {
        cache.remove(id)
    }

    fun clear() {
        cache.clear()
    }

    fun size(): Int {
        return cache.size
    }

    fun values(): List<Workflow> {
        return cache.values.toList()
    }

    fun ids(): List<String> {
        return cache.keys.toList()
    }

    fun isEmpty(): Boolean {
        return cache.isEmpty()
    }
}
