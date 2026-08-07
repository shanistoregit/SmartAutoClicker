package com.smartautoclicker.app.automation

import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean

object AutomationManager {

    private const val TAG = "AutomationManager"

    private val running = AtomicBoolean(false)
    private val paused = AtomicBoolean(false)

    fun start(): Boolean {

        if (running.get()) {
            Log.d(TAG, "Automation already running.")
            return false
        }

        running.set(true)
        paused.set(false)

        Log.i(TAG, "Automation started.")

        return true
    }

    fun stop() {

        if (!running.get()) {
            return
        }

        running.set(false)
        paused.set(false)

        Log.i(TAG, "Automation stopped.")
    }

    fun pause() {

        if (!running.get()) {
            return
        }

        paused.set(true)

        Log.i(TAG, "Automation paused.")
    }

    fun resume() {

        if (!running.get()) {
            return
        }

        paused.set(false)

        Log.i(TAG, "Automation resumed.")
    }

    fun isRunning(): Boolean {
        return running.get()
    }

    fun isPaused(): Boolean {
        return paused.get()
    }

    fun reset() {
        running.set(false)
        paused.set(false)
    }
}
