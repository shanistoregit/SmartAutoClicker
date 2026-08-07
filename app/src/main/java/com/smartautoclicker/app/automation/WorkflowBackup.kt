package com.smartautoclicker.app.automation

data class WorkflowBackup(

    val id: String,

    val workflow: Workflow,

    val createdAt: Long = System.currentTimeMillis(),

    val note: String = ""

)
