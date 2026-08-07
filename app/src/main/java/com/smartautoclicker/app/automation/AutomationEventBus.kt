package com.smartautoclicker.app.automation

import java.util.concurrent.CopyOnWriteArrayList

object AutomationEventBus {

    enum class EventType {
        STARTED,
        STOPPED,
        PAUSED,
        RESUMED,
        STEP_STARTED,
        STEP_COMPLETED,
        WORKFLOW_COMPLETED,
        ERROR
    }

    data class Event(
        val type: EventType,
        val message: String = "",
        val timestamp: Long = System.currentTimeMillis()
    )

    private val listeners =
        CopyOnWriteArrayList<(Event) -> Unit>()

    fun register(listener: (Event) -> Unit) {
        if (!listeners.contains(listener)) {
            listeners.add(listener)
        }
    }

    fun unregister(listener: (Event) -> Unit) {
        listeners.remove(listener)
    }

    fun clear() {
        listeners.clear()
    }

    fun post(event: Event) {

        listeners.forEach {

            try {
                it.invoke(event)
            } catch (_: Exception) {
                // Prevent one listener from affecting others.
            }

        }
    }

    fun started() {
        post(Event(EventType.STARTED))
    }

    fun stopped() {
        post(Event(EventType.STOPPED))
    }

    fun paused() {
        post(Event(EventType.PAUSED))
    }

    fun resumed() {
        post(Event(EventType.RESUMED))
    }

    fun stepStarted(stepId: String) {
        post(
            Event(
                EventType.STEP_STARTED,
                stepId
            )
        )
    }

    fun stepCompleted(stepId: String) {
        post(
            Event(
                EventType.STEP_COMPLETED,
                stepId
            )
        )
    }

    fun workflowCompleted() {
        post(Event(EventType.WORKFLOW_COMPLETED))
    }

    fun error(message: String) {
        post(
            Event(
                EventType.ERROR,
                message
            )
        )
    }
}
