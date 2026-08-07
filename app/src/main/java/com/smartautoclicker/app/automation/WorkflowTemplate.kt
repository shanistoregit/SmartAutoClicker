package com.smartautoclicker.app.automation

data class WorkflowTemplate(

    val id: String,

    val name: String,

    val description: String = "",

    val category: String = "General",

    val workflow: Workflow

)
