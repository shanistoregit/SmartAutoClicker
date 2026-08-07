package com.smartautoclicker.app.accessibility

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class SmartAccessibilityService : AccessibilityService() {

    companion object {
        private const val TAG = "SmartAccessibility"
        var instance: SmartAccessibilityService? = null
            private set
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
        Log.i(TAG, "Accessibility Service Connected")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return

        when (event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED,
            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> {

                val root: AccessibilityNodeInfo = rootInActiveWindow ?: return

                Log.d(
                    TAG,
                    "Package=${event.packageName}, Class=${event.className}"
                )

                // Automation engine will process the UI tree here.
            }
        }
    }

    override fun onInterrupt() {
        Log.w(TAG, "Accessibility Service Interrupted")
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }

    fun getRootNode(): AccessibilityNodeInfo? {
        return rootInActiveWindow
    }
}
