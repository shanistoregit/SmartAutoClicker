package com.smartautoclicker.app.automation

class WorkflowContext {

    private val variables = mutableMapOf<String, String>()

    var lastError: String? = null
        private set

    var startedAt: Long = System.currentTimeMillis()
        private set

    fun put(key: String, value: String) {
        variables[key] = value
    }

    fun get(key: String): String? {
        return variables[key]
    }

    fun contains(key: String): Boolean {
        return variables.containsKey(key)
    }

    fun remove(key: String) {
        variables.remove(key)
    }

    fun clear() {
        variables.clear()
        lastError = null
        startedAt = System.currentTimeMillis()
    }

    fun keys(): Set<String> {
        return variables.keys
    }

    fun values(): Collection<String> {
        return variables.values
    }

    fun all(): Map<String, String> {
        return variables.toMap()
    }

    fun setError(message: String) {
        lastError = message
    }

    fun hasError(): Boolean {
        return lastError != null
    }

    fun uptime(): Long {
        return System.currentTimeMillis() - startedAt
    }
}
