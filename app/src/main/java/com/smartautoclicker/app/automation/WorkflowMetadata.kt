package com.smartautoclicker.app.automation

data class WorkflowMetadata(

    val createdAt: Long = System.currentTimeMillis(),

    var updatedAt: Long = System.currentTimeMillis(),

    var version: Int = 1,

    var author: String = "",

    var description: String = "",

    var favorite: Boolean = false

) {

    fun touch() {
        updatedAt = System.currentTimeMillis()
        version++
    }
}
