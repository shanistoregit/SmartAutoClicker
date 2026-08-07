package com.smartautoclicker.app.automation

data class AutomationSettings(

    var darkMode: Boolean = false,

    var showOverlay: Boolean = true,

    var vibrationEnabled: Boolean = true,

    var soundEnabled: Boolean = false,

    var saveLogs: Boolean = true,

    var autoSaveWorkflows: Boolean = true,

    var keepScreenAwake: Boolean = false,

    var debugMode: Boolean = false

) {

    fun reset() {
        darkMode = false
        showOverlay = true
        vibrationEnabled = true
        soundEnabled = false
        saveLogs = true
        autoSaveWorkflows = true
        keepScreenAwake = false
        debugMode = false
    }

    fun copyFrom(other: AutomationSettings) {
        darkMode = other.darkMode
        showOverlay = other.showOverlay
        vibrationEnabled = other.vibrationEnabled
        soundEnabled = other.soundEnabled
        saveLogs = other.saveLogs
        autoSaveWorkflows = other.autoSaveWorkflows
        keepScreenAwake = other.keepScreenAwake
        debugMode = other.debugMode
    }

    fun validate(): Boolean {
        return true
    }
}
