package com.smartautoclicker.app.automation

data class WorkflowTriggerConfig(

    var trigger: WorkflowTrigger = WorkflowTrigger.MANUAL,

    var enabled: Boolean = true,

    var parameter: String = "",

    var delayMillis: Long = 0L

) {

    fun validate(): Boolean {
        return delayMillis >= 0L
    }
}
