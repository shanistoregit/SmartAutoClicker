package com.smartautoclicker.app.automation

import android.util.Log

object AutomationLogger {

    private const val TAG = "SmartAutoClicker"

    var enabled = true

    fun d(message: String) {
        if (enabled) {
            Log.d(TAG, message)
        }
    }

    fun i(message: String) {
        if (enabled) {
            Log.i(TAG, message)
        }
    }

    fun w(message: String) {
        if (enabled) {
            Log.w(TAG, message)
        }
    }

    fun e(message: String) {
        if (enabled) {
            Log.e(TAG, message)
        }
    }

    fun e(message: String, throwable: Throwable) {
        if (enabled) {
            Log.e(TAG, message, throwable)
        }
    }
}
