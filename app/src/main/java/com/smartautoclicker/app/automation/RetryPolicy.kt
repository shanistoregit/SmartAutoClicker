package com.smartautoclicker.app.automation

data class RetryPolicy(

    var maxRetries: Int = 3,

    var retryDelay: Long = 1000L,

    var exponentialBackoff: Boolean = false,

    var backoffMultiplier: Double = 2.0

) {

    init {
        require(maxRetries >= 0) {
            "maxRetries cannot be negative."
        }

        require(retryDelay >= 0L) {
            "retryDelay cannot be negative."
        }

        require(backoffMultiplier >= 1.0) {
            "backoffMultiplier must be at least 1.0."
        }
    }

    fun getDelay(attempt: Int): Long {

        if (!exponentialBackoff) {
            return retryDelay
        }

        return (retryDelay * Math.pow(
            backoffMultiplier,
            attempt.toDouble()
        )).toLong()
    }

    fun shouldRetry(attempt: Int): Boolean {
        return attempt < maxRetries
    }

    fun reset(): RetryPolicy {

        return RetryPolicy(
            maxRetries = maxRetries,
            retryDelay = retryDelay,
            exponentialBackoff = exponentialBackoff,
            backoffMultiplier = backoffMultiplier
        )
    }
}
