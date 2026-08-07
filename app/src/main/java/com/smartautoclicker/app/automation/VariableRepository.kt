package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object VariableRepository {

    private val variables =
        ConcurrentHashMap<String, WorkflowVariable>()

    fun put(variable: WorkflowVariable) {
        variables[variable.key] = variable
    }

    fun set(key: String, value: String) {
        variables[key] = WorkflowVariable(key, value)
    }

    fun get(key: String): WorkflowVariable? {
        return variables[key]
    }

    fun getValue(key: String): String? {
        return variables[key]?.value
    }

    fun contains(key: String): Boolean {
        return variables.containsKey(key)
    }

    fun remove(key: String) {
        variables.remove(key)
    }

    fun clear() {
        variables.clear()
    }

    fun all(): List<WorkflowVariable> {
        return variables.values.sortedBy { it.key }
    }
}
