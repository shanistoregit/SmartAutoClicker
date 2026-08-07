package com.smartautoclicker.app.automation

data class WorkflowGroup(

    val id: String,

    val name: String,

    val workflowIds: MutableList<String> = mutableListOf()

) {

    fun add(id: String) {

        if (!workflowIds.contains(id)) {
            workflowIds.add(id)
        }
    }

    fun remove(id: String) {
        workflowIds.remove(id)
    }

    fun contains(id: String): Boolean {
        return workflowIds.contains(id)
    }

    fun clear() {
        workflowIds.clear()
    }

    fun count(): Int {
        return workflowIds.size
    }
}
