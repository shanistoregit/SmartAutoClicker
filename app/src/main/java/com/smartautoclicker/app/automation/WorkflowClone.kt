package com.smartautoclicker.app.automation

object WorkflowClone {

    fun clone(
        workflow: Workflow,
        newId: String,
        newName: String
    ): Workflow {

        val copy = Workflow(
            id = newId,
            name = newName,
            enabled = workflow.enabled
        )

        workflow.steps.forEach { step ->

            copy.steps.add(
                WorkflowStep(
                    id = step.id,
                    action = step.action,
                    condition = step.condition,
                    value = step.value,
                    timeout = step.timeout,
                    retryCount = step.retryCount,
                    enabled = step.enabled
                )
            )
        }

        return copy
    }
}
