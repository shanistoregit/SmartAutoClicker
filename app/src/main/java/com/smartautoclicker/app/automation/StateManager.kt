package com.smartautoclicker.app.automation

import java.util.concurrent.atomic.AtomicReference

object StateManager {

    private val currentState =
        AtomicReference(ExecutionState.IDLE)

    fun getState(): ExecutionState {
        return currentState.get()
    }

    fun setState(state: ExecutionState) {
        currentState.set(state)
        AutomationLogger.d("Execution state changed to: $state")
    }

    fun reset() {
        currentState.set(ExecutionState.IDLE)
    }

    fun isIdle(): Boolean {
        return currentState.get() == ExecutionState.IDLE
    }

    fun isRunning(): Boolean {
        return currentState.get() == ExecutionState.RUNNING
    }

    fun isPaused(): Boolean {
        return currentState.get() == ExecutionState.PAUSED
    }

    fun isWaiting(): Boolean {
        return currentState.get() == ExecutionState.WAITING
    }

    fun isFinished(): Boolean {
        return currentState.get().isFinished()
    }

    fun compareAndSet(
        expected: ExecutionState,
        newState: ExecutionState
    ): Boolean {

        return currentState.compareAndSet(
            expected,
            newState
        )
    }
}
