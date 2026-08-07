package com.smartautoclicker.app.automation

data class WorkflowFilter(

    var enabledOnly: Boolean = false,

    var favoritesOnly: Boolean = false,

    var nameContains: String = "",

    var author: String = ""

) {

    fun matches(
        workflow: Workflow,
        metadata: WorkflowMetadata?
    ): Boolean {

        if (enabledOnly && !workflow.enabled) {
            return false
        }

        if (favoritesOnly && metadata?.favorite != true) {
            return false
        }

        if (
            nameContains.isNotBlank() &&
            !workflow.name.contains(nameContains, true)
        ) {
            return false
        }

        if (
            author.isNotBlank() &&
            metadata?.author != author
        ) {
            return false
        }

        return true
    }
}
