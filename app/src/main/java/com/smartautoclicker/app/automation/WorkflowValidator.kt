package com.smartautoclicker.app.automation

object WorkflowValidator {

    data class ValidationResult(
        val valid: Boolean,
        val errors: List<String>
    )

    fun validate(workflow: Workflow): ValidationResult {

        val errors = mutableListOf<String>()

        if (workflow.id.isBlank()) {
            errors.add("Workflow ID cannot be empty.")
        }

        if (workflow.name.isBlank()) {
            errors.add("Workflow name cannot be empty.")
        }

        if (workflow.steps.isEmpty()) {
            errors.add("Workflow must contain at least one step.")
        }

        workflow.steps.forEachIndexed { index, step ->

            if (step.id.isBlank()) {
                errors.add("Step ${index + 1}: ID cannot be empty.")
            }

            if (step.timeout < 0) {
                errors.add("Step ${index + 1}: Timeout cannot be negative.")
            }

            if (step.retryCount < 0) {
                errors.add("Step ${index + 1}: Retry count cannot be negative.")
            }

            when (step.condition) {

                ConditionType.TEXT_EXISTS,
                ConditionType.TEXT_NOT_EXISTS,
                ConditionType.VIEW_ID_EXISTS,
                ConditionType.VIEW_ID_NOT_EXISTS,
                ConditionType.PACKAGE_IS -> {

                    if (step.value.isBlank()) {
                        errors.add(
                            "Step ${index + 1}: Value is required for ${step.condition}."
                        )
                    }
                }

                else -> {
                    // No validation needed.
                }
            }
        }

        return ValidationResult(
            valid = errors.isEmpty(),
            errors = errors
        )
    }
}
