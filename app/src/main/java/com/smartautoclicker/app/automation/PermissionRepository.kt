package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object PermissionRepository {

    private val permissions =
        ConcurrentHashMap<WorkflowPermission, Boolean>()

    init {
        WorkflowPermission.values().forEach {
            permissions[it] = false
        }
    }

    fun set(
        permission: WorkflowPermission,
        granted: Boolean
    ) {
        permissions[permission] = granted
    }

    fun isGranted(
        permission: WorkflowPermission
    ): Boolean {
        return permissions[permission] ?: false
    }

    fun granted(): List<WorkflowPermission> {
        return permissions
            .filterValues { it }
            .keys
            .toList()
    }

    fun revokeAll() {
        WorkflowPermission.values().forEach {
            permissions[it] = false
        }
    }
}
