package com.smartautoclicker.app.automation

data class WorkflowLimits(

    var maxExecutionTime: Long = 300000L,

    var maxSteps: Int = 1000,

    var maxRetriesPerStep: Int = 10,

    var maxVariables: Int = 200

) {

    fun validate(): Boolean {

        return maxExecutionTime > 0 &&
                maxSteps > 0 &&
                maxRetriesPerStep >= 0 &&
                maxVariables >= 0
    }
}
