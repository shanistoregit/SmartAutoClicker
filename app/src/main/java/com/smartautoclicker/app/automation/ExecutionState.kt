package com.smartautoclicker.app.automation

enum class ExecutionState {

    IDLE,

    INITIALIZING,

    VALIDATING,

    WAITING,

    RUNNING,

    PAUSED,

    RETRYING,

    COMPLETED,

    FAILED,

    STOPPED,

    CANCELLED

}

fun ExecutionState.isActive(): Boolean {

    return this == ExecutionState.INITIALIZING ||
            this == ExecutionState.VALIDATING ||
            this == ExecutionState.WAITING ||
            this == ExecutionState.RUNNING ||
            this == ExecutionState.RETRYING
}

fun ExecutionState.isFinished(): Boolean {

    return this == ExecutionState.COMPLETED ||
            this == ExecutionState.FAILED ||
            this == ExecutionState.STOPPED ||
            this == ExecutionState.CANCELLED
}

fun ExecutionState.canStart(): Boolean {

    return this == ExecutionState.IDLE ||
            this == ExecutionState.COMPLETED ||
            this == ExecutionState.FAILED ||
            this == ExecutionState.STOPPED ||
            this == ExecutionState.CANCELLED
}

fun ExecutionState.canPause(): Boolean {

    return this == ExecutionState.RUNNING ||
            this == ExecutionState.WAITING
}

fun ExecutionState.canResume(): Boolean {

    return this == ExecutionState.PAUSED
}
