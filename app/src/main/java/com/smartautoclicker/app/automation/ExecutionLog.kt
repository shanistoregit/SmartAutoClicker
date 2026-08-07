package com.smartautoclicker.app.automation

data class ExecutionLog(

    val id: String,

    val workflowId: String,

    val timestamp: Long = System.currentTimeMillis(),

    val level: Level,

    val message: String

) {

    enum class Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }
}
