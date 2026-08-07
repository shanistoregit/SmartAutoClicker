package com.smartautoclicker.app.automation

import android.util.Log

object ActionExecutor {

    private const val TAG = "ActionExecutor"

    fun execute(step: WorkflowStep): Boolean {

        if (!step.enabled) {
            Log.d(TAG, "Skipped disabled step: ${step.id}")
            return true
        }

        Log.d(TAG, "Executing: ${step.action}")

        return when (step.action) {

            ActionType.WAIT -> {
                Thread.sleep(step.timeout)
                true
            }

            ActionType.DELAY -> {
                Thread.sleep(step.timeout)
                true
            }

            ActionType.BACK -> {
                Log.d(TAG, "BACK action requested.")
                false
            }

            ActionType.HOME -> {
                Log.d(TAG, "HOME action requested.")
                false
            }

            ActionType.RECENTS -> {
                Log.d(TAG, "RECENTS action requested.")
                false
            }

            ActionType.CLICK -> {
                Log.d(TAG, "CLICK action requested.")
                false
            }

            ActionType.LONG_CLICK -> {
                Log.d(TAG, "LONG_CLICK action requested.")
                false
            }

            ActionType.DOUBLE_CLICK -> {
                Log.d(TAG, "DOUBLE_CLICK action requested.")
                false
            }

            ActionType.SWIPE -> {
                Log.d(TAG, "SWIPE action requested.")
                false
            }

            ActionType.SCROLL -> {
                Log.d(TAG, "SCROLL action requested.")
                false
            }

            ActionType.INPUT_TEXT -> {
                Log.d(TAG, "INPUT_TEXT action requested.")
                false
            }
        }
    }
}
