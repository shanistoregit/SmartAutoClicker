package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object WorkflowFavorite {

    private val favorites =
        ConcurrentHashMap<String, Boolean>()

    fun set(workflowId: String, favorite: Boolean) {
        favorites[workflowId] = favorite
    }

    fun isFavorite(workflowId: String): Boolean {
        return favorites[workflowId] ?: false
    }

    fun remove(workflowId: String) {
        favorites.remove(workflowId)
    }

    fun clear() {
        favorites.clear()
    }

    fun all(): List<String> {
        return favorites.filterValues { it }.keys.toList()
    }
}
