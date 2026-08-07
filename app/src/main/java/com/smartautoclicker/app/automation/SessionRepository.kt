package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object SessionRepository {

    private val sessions =
        ConcurrentHashMap<String, WorkflowSession>()

    fun add(session: WorkflowSession) {
        sessions[session.sessionId] = session
    }

    fun get(sessionId: String): WorkflowSession? {
        return sessions[sessionId]
    }

    fun remove(sessionId: String) {
        sessions.remove(sessionId)
    }

    fun all(): List<WorkflowSession> {
        return sessions.values.sortedByDescending {
            it.startedAt
        }
    }

    fun clear() {
        sessions.clear()
    }

    fun count(): Int {
        return sessions.size
    }
}
