package com.smartautoclicker.app.automation

import java.util.concurrent.CopyOnWriteArrayList

object ExecutionLogRepository {

    private const val MAX_LOGS = 500

    private val logs = CopyOnWriteArrayList<ExecutionLog>()

    fun add(log: ExecutionLog) {

        logs.add(log)

        while (logs.size > MAX_LOGS) {
            logs.removeAt(0)
        }
    }

    fun all(): List<ExecutionLog> {
        return logs.toList()
    }

    fun clear() {
        logs.clear()
    }

    fun size(): Int {
        return logs.size
    }

    fun latest(): ExecutionLog? {
        return logs.lastOrNull()
    }
}
