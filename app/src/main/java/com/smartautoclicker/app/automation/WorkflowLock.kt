package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object WorkflowLock {

    private val locks =
        ConcurrentHashMap<String, Long>()

    fun lock(workflowId: String): Boolean {

        if (workflowId.isBlank()) {
            return false
        }

        return locks.putIfAbsent(
            workflowId,
            System.currentTimeMillis()
        ) == null
    }

    fun unlock(workflowId: String) {
        locks.remove(workflowId)
    }

    fun isLocked(workflowId: String): Boolean {
        return locks.containsKey(workflowId)
    }

    fun clear() {
        locks.clear()
    }

    fun lockedWorkflows(): List<String> {
        return locks.keys.toList()
    }

    fun lockTime(workflowId: String): Long? {
        return locks[workflowId]
    }

    fun count(): Int {
        return locks.size
    }
}
