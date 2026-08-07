package com.smartautoclicker.app.automation

import android.view.accessibility.AccessibilityNodeInfo

class WorkflowRunner {

    private var workflow: Workflow? = null
    private var currentStepIndex = 0

    private val context = WorkflowContext()

    fun load(workflow: Workflow): Boolean {

        val result = WorkflowValidator.validate(workflow)

        if (!result.valid) {

            AutomationLogger.e("Workflow validation failed")

            result.errors.forEach {
                AutomationLogger.e(it)
            }

            return false
        }

        this.workflow = workflow
        currentStepIndex = 0
        context.clear()

        AutomationLogger.i("Workflow loaded: ${workflow.name}")

        return true
    }

    fun reset() {
        currentStepIndex = 0
        context.clear()
    }

    fun isFinished(): Boolean {
        val wf = workflow ?: return true
        return currentStepIndex >= wf.steps.size
    }

    fun currentStep(): WorkflowStep? {

        val wf = workflow ?: return null

        if (currentStepIndex >= wf.steps.size) {
            return null
        }

        return wf.steps[currentStepIndex]
    }

    fun runNext(root: AccessibilityNodeInfo?): Boolean {

        val wf = workflow ?: return false

        if (currentStepIndex >= wf.steps.size) {
            AutomationLogger.i("Workflow completed.")
            return false
        }

        val step = wf.steps[currentStepIndex]

        if (!step.enabled) {
            currentStepIndex++
            return true
        }

        if (!ConditionChecker.check(root, step)) {
            return false
        }

        val executed = ActionExecutor.execute(step)

        if (!executed) {
            context.setError("Action failed: ${step.action}")
            AutomationLogger.e(context.lastError ?: "Unknown error")
            return false
        }

        context.put("last_action", step.action.name)
        context.put("last_step", step.id)

        currentStepIndex++

        AutomationLogger.d(
            "Step $currentStepIndex of ${wf.steps.size} completed."
        )

        return true
    }

    fun getProgress(): Float {

        val wf = workflow ?: return 0f

        if (wf.steps.isEmpty()) {
            return 0f
        }

        return currentStepIndex.toFloat() / wf.steps.size.toFloat()
    }

    fun getCurrentIndex(): Int {
        return currentStepIndex
    }

    fun getWorkflow(): Workflow? {
        return workflow
    }

    fun getContext(): WorkflowContext {
        return context
    }
}
