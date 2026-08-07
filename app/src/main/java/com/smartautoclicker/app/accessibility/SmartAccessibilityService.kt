package com.smartautoclicker.app.accessibility

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.smartautoclicker.app.automation.AutomationManager
import com.smartautoclicker.app.automation.Workflow
import com.smartautoclicker.app.automation.WorkflowRunner

class SmartAccessibilityService : AccessibilityService() {

    companion object {
        private const val TAG = "SmartAccessibility"

        var instance: SmartAccessibilityService? = null
            private set
    }

    private val workflowRunner = WorkflowRunner()

    override fun onServiceConnected() {
        super.onServiceConnected()

        instance = this

        Log.i(TAG, "Accessibility Service Connected")

        workflowRunner.load(
            Workflow(
                id = "default",
                name = "Default Workflow"
            )
        )
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {

        if (event == null) {
            return
        }

        if (!AutomationManager.isRunning()) {
            return
        }

        when (event.eventType) {

            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED,
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {

                val root = rootInActiveWindow ?: return

                processCurrentScreen(root)
            }
        }
    }

    private fun processCurrentScreen(root: AccessibilityNodeInfo) {

        if (AutomationManager.isPaused()) {
            return
        }

        try {

            workflowRunner.runNext(root)

        } catch (e: Exception) {

            Log.e(
                TAG,
                "Workflow execution error",
                e
            )
        }
    }

    override fun onInterrupt() {
        Log.w(TAG, "Accessibility Service Interrupted")
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }

    fun currentRoot(): AccessibilityNodeInfo? {
        return rootInActiveWindow
    }
}
