package com.smartautoclicker.app.automation

import java.util.LinkedList

object WorkflowHistory {

    data class HistoryEntry(
        val workflowId: String,
        val workflowName: String,
        val success: Boolean,
        val startedAt: Long,
        val finishedAt: Long,
        val message: String
    )

    private const val MAX_HISTORY = 100

    private val history = LinkedList<HistoryEntry>()

    fun add(entry: HistoryEntry) {

        synchronized(history) {

            history.addFirst(entry)

            while (history.size > MAX_HISTORY) {
                history.removeLast()
            }
        }
    }

    fun all(): List<HistoryEntry> {

        synchronized(history) {
            return history.toList()
        }
    }

    fun latest(): HistoryEntry? {

        synchronized(history) {
            return history.firstOrNull()
        }
    }

    fun clear() {

        synchronized(history) {
            history.clear()
        }
    }

    fun size(): Int {

        synchronized(history) {
            return history.size
        }
    }

    fun successfulRuns(): Int {

        synchronized(history) {
            return history.count { it.success }
        }
    }

    fun failedRuns(): Int {

        synchronized(history) {
            return history.count { !it.success }
        }
    }
}
