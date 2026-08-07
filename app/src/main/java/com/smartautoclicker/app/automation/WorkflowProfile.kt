package com.smartautoclicker.app.automation

data class WorkflowProfile(

    val id: String,

    val name: String,

    val workflowIds: MutableList<String> = mutableListOf(),

    var createdAt: Long = System.currentTimeMillis(),

    var updatedAt: Long = System.currentTimeMillis()

) {

    fun add(workflowId: String) {

        if (!workflowIds.contains(workflowId)) {
            workflowIds.add(workflowId)
            updatedAt = System.currentTimeMillis()
        }
    }

    fun remove(workflowId: String) {

        if (workflowIds.remove(workflowId)) {
            updatedAt = System.currentTimeMillis()
        }
    }

    fun contains(workflowId: String): Boolean {
        return workflowIds.contains(workflowId)
    }

    fun count(): Int {
        return workflowIds.size
    }
}
