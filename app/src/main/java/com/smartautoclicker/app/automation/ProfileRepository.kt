package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object ProfileRepository {

    private val profiles =
        ConcurrentHashMap<String, WorkflowProfile>()

    fun add(profile: WorkflowProfile) {
        profiles[profile.id] = profile
    }

    fun get(id: String): WorkflowProfile? {
        return profiles[id]
    }

    fun update(profile: WorkflowProfile) {
        profiles[profile.id] = profile
    }

    fun remove(id: String) {
        profiles.remove(id)
    }

    fun exists(id: String): Boolean {
        return profiles.containsKey(id)
    }

    fun all(): List<WorkflowProfile> {
        return profiles.values.sortedBy { it.name }
    }

    fun clear() {
        profiles.clear()
    }

    fun count(): Int {
        return profiles.size
    }
}
