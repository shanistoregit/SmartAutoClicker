package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentLinkedQueue

object WorkflowScheduler {

    private val pendingQueue =
        ConcurrentLinkedQueue<String>()

    fun schedule(workflowId: String): Boolean {

        if (workflowId.isBlank()) {
            return false
        }

        pendingQueue.offer(workflowId)

        AutomationLogger.d(
            "Scheduled workflow: $workflowId"
        )

        return true
    }

    fun next(): String? {
        return pendingQueue.poll()
    }

    fun peek(): String? {
        return pendingQueue.peek()
    }

    fun remove(workflowId: String): Boolean {
        return pendingQueue.remove(workflowId)
    }

    fun clear() {
        pendingQueue.clear()
    }

    fun size(): Int {
        return pendingQueue.size
    }

    fun isEmpty(): Boolean {
        return pendingQueue.isEmpty()
    }

    fun contains(workflowId: String): Boolean {
        return pendingQueue.contains(workflowId)
    }

    fun all(): List<String> {
        return pendingQueue.toList()
    }
}
