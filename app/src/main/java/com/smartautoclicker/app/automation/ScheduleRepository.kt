package com.smartautoclicker.app.automation

import java.util.concurrent.ConcurrentHashMap

object ScheduleRepository {

    private val schedules =
        ConcurrentHashMap<String, WorkflowSchedule>()

    fun add(schedule: WorkflowSchedule) {
        schedules[schedule.workflowId] = schedule
    }

    fun get(workflowId: String): WorkflowSchedule? {
        return schedules[workflowId]
    }

    fun remove(workflowId: String) {
        schedules.remove(workflowId)
    }

    fun all(): List<WorkflowSchedule> {
        return schedules.values
            .sortedBy { it.nextRun }
    }

    fun clear() {
        schedules.clear()
    }

    fun count(): Int {
        return schedules.size
    }

    fun readySchedules(): List<WorkflowSchedule> {

        return schedules.values
            .filter { it.isReady() }
            .sortedByDescending {
                it.priority.level
            }
    }
}
