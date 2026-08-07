package com.smartautoclicker.app.automation

import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo

class WorkflowRunner {

    companion object {
        private const val TAG = "WorkflowRunner"
    }

    private var workflow: Workflow? = null
    private var currentStepIndex = 0

    fun load(workflow: Workflow) {
        this.workflow = workflow
        currentStepIndex = 0
    }

    fun reset() {
        currentStepIndex = 0
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
            Log.d(TAG, "Workflow completed.")
            return false
        }

        val step = wf.steps[currentStepIndex]

        if (!step.enabled) {
            currentStepIndex++
            return true
        }

        val conditionPassed =
            ConditionChecker.check(root, step)

        if (!conditionPassed) {
            Log.d(TAG, "Waiting for condition: ${step.condition}")
            return false
        }

        val actionSuccess =
            ActionExecutor.execute(step)

        if (!actionSuccess) {
            Log.d(TAG, "Action failed: ${step.action}")
            return false
        }

        currentStepIndex++

        Log.d(
            TAG,
            "Moved to step $currentStepIndex/${wf.steps.size}"
        )

        return true
    }
}
