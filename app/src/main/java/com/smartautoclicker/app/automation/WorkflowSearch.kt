package com.smartautoclicker.app.automation

object WorkflowSearch {

    fun byName(
        workflows: List<Workflow>,
        query: String
    ): List<Workflow> {

        if (query.isBlank()) {
            return workflows
        }

        return workflows.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun byId(
        workflows: List<Workflow>,
        id: String
    ): Workflow? {

        return workflows.firstOrNull {
            it.id == id
        }
    }

    fun enabled(
        workflows: List<Workflow>
    ): List<Workflow> {

        return workflows.filter {
            it.enabled
        }
    }
}
