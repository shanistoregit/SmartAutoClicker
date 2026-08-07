package com.smartautoclicker.app.automation

class ExecutionTimer {

    private var startTime: Long = 0L
    private var endTime: Long = 0L
    private var running = false

    fun start() {
        startTime = System.currentTimeMillis()
        endTime = 0L
        running = true
    }

    fun stop() {
        if (running) {
            endTime = System.currentTimeMillis()
            running = false
        }
    }

    fun reset() {
        startTime = 0L
        endTime = 0L
        running = false
    }

    fun isRunning(): Boolean {
        return running
    }

    fun elapsed(): Long {

        if (startTime == 0L) {
            return 0L
        }

        return if (running) {
            System.currentTimeMillis() - startTime
        } else {
            endTime - startTime
        }
    }

    fun elapsedSeconds(): Long {
        return elapsed() / 1000L
    }

    fun elapsedMinutes(): Long {
        return elapsed() / 60000L
    }

    fun startedAt(): Long {
        return startTime
    }

    fun finishedAt(): Long {
        return endTime
    }
}
