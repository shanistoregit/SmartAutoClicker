package com.smartautoclicker.app.automation

import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.atomic.AtomicBoolean

object AutomationEngine {

    private val executor = Executors.newSingleThreadExecutor()

    private var future: Future<*>? = null

    private val running = AtomicBoolean(false)

    fun start(task: () -> Unit): Boolean {

        if (running.get()) {
            return false
        }

        running.set(true)

        future = executor.submit {

            try {
                task()
            } finally {
                running.set(false)
            }

        }

        return true
    }

    fun stop() {

        running.set(false)

        future?.cancel(true)

        future = null
    }

    fun isRunning(): Boolean {
        return running.get()
    }

    fun canRun(): Boolean {
        return !running.get()
    }

    fun shutdown() {
        stop()
        executor.shutdownNow()
    }
}
