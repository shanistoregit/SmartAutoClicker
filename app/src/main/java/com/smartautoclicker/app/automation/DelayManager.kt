package com.smartautoclicker.app.automation

object DelayManager {

    fun wait(milliseconds: Long): Boolean {

        if (milliseconds <= 0L) {
            return true
        }

        return try {
            Thread.sleep(milliseconds)
            true
        } catch (_: InterruptedException) {
            false
        }
    }

    fun waitSeconds(seconds: Int): Boolean {
        return wait(seconds * 1000L)
    }

    fun waitMinutes(minutes: Int): Boolean {
        return wait(minutes * 60_000L)
    }

    fun retry(
        attempts: Int,
        delay: Long,
        action: () -> Boolean
    ): Boolean {

        var count = 0

        while (count < attempts) {

            if (action()) {
                return true
            }

            if (count < attempts - 1) {
                wait(delay)
            }

            count++
        }

        return false
    }
}
