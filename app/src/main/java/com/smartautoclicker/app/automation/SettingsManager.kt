package com.smartautoclicker.app.automation

import android.content.Context
import android.content.SharedPreferences

object SettingsManager {

    private const val PREF_NAME = "smart_auto_clicker"

    private lateinit var preferences: SharedPreferences

    fun initialize(context: Context) {
        preferences = context.getSharedPreferences(
            PREF_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun save(settings: AutomationSettings) {

        preferences.edit().apply {

            putBoolean("darkMode", settings.darkMode)
            putBoolean("showOverlay", settings.showOverlay)
            putBoolean("vibrationEnabled", settings.vibrationEnabled)
            putBoolean("soundEnabled", settings.soundEnabled)
            putBoolean("saveLogs", settings.saveLogs)
            putBoolean("autoSaveWorkflows", settings.autoSaveWorkflows)
            putBoolean("keepScreenAwake", settings.keepScreenAwake)
            putBoolean("debugMode", settings.debugMode)

            apply()
        }
    }

    fun load(): AutomationSettings {

        return AutomationSettings(

            darkMode =
                preferences.getBoolean("darkMode", false),

            showOverlay =
                preferences.getBoolean("showOverlay", true),

            vibrationEnabled =
                preferences.getBoolean("vibrationEnabled", true),

            soundEnabled =
                preferences.getBoolean("soundEnabled", false),

            saveLogs =
                preferences.getBoolean("saveLogs", true),

            autoSaveWorkflows =
                preferences.getBoolean("autoSaveWorkflows", true),

            keepScreenAwake =
                preferences.getBoolean("keepScreenAwake", false),

            debugMode =
                preferences.getBoolean("debugMode", false)
        )
    }

    fun clear() {
        preferences.edit().clear().apply()
    }

    fun contains(key: String): Boolean {
        return preferences.contains(key)
    }
}
