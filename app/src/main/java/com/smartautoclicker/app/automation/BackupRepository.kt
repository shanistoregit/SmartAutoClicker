package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object BackupRepository {

    private val backups =
        ConcurrentHashMap<String, WorkflowBackup>()

    fun save(backup: WorkflowBackup) {
        backups[backup.id] = backup
    }

    fun get(id: String): WorkflowBackup? {
        return backups[id]
    }

    fun remove(id: String) {
        backups.remove(id)
    }

    fun exists(id: String): Boolean {
        return backups.containsKey(id)
    }

    fun clear() {
        backups.clear()
    }

    fun all(): List<WorkflowBackup> {
        return backups.values.sortedByDescending {
            it.createdAt
        }
    }

    fun count(): Int {
        return backups.size
    }
}
