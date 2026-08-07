package com.smartautoclicker.app.automation

data class Workflow(

    val id: String,

    val name: String,

    val enabled: Boolean = true,

    val steps: MutableList<WorkflowStep> = mutableListOf()

)

data class WorkflowStep(

    val id: String,

    val action: ActionType,

    val condition: ConditionType = ConditionType.NONE,

    val value: String = "",

    val timeout: Long = 10000L,

    val retryCount: Int = 0,

    val enabled: Boolean = true

)

enum class ActionType {

    CLICK,

    LONG_CLICK,

    DOUBLE_CLICK,

    SWIPE,

    SCROLL,

    INPUT_TEXT,

    BACK,

    HOME,

    RECENTS,

    WAIT,

    DELAY

}

enum class ConditionType {

    NONE,

    TEXT_EXISTS,

    TEXT_NOT_EXISTS,

    VIEW_ID_EXISTS,

    VIEW_ID_NOT_EXISTS,

    PACKAGE_IS,

    IMAGE_FOUND,

    OCR_TEXT_FOUND

}
