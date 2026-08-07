package com.smartautoclicker.app.automation

data class AutomationConfig(

    var stopOnError: Boolean = true,

    var enableLogging: Boolean = true,

    var defaultTimeout: Long = 10000L,

    var defaultRetryCount: Int = 3,

    var retryDelay: Long = 1000L,

    var loopWorkflow: Boolean = false,

    var maxLoopCount: Int = 1,

    var continueOnStepFailure: Boolean = false,

    var pauseWhenScreenChanges: Boolean = false,

    var autoResetAfterFinish: Boolean = false

) {

    fun isValid(): Boolean {

        if (defaultTimeout < 0) return false
        if (defaultRetryCount < 0) return false
        if (retryDelay < 0) return false
        if (maxLoopCount < 1) return false

        return true
    }

    fun copyDefault(): AutomationConfig {
        return AutomationConfig(
            stopOnError = stopOnError,
            enableLogging = enableLogging,
            defaultTimeout = defaultTimeout,
            defaultRetryCount = defaultRetryCount,
            retryDelay = retryDelay,
            loopWorkflow = loopWorkflow,
            maxLoopCount = maxLoopCount,
            continueOnStepFailure = continueOnStepFailure,
            pauseWhenScreenChanges = pauseWhenScreenChanges,
            autoResetAfterFinish = autoResetAfterFinish
        )
    }
}
