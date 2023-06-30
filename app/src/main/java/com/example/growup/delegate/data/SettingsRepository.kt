package com.example.growup.delegate.data

import android.content.SharedPreferences
import androidx.core.content.edit

class SettingsRepository(private val preferences: SharedPreferences) {

    var switcher: Boolean by preferences.booleanDelegate(false)
    var seekBar: Float by preferences.floatDelegate(0f)
    var name: String? by preferences.stringDelegate("")
    companion object {
        const val SWITCHER_KEY = "switcher_key"
        const val SEEK_BAR_KEY = "seek_bar_key"
        const val NAME_KEY = "name_key"
    }

    fun removePreference(key: String) {
        preferences.edit { remove(key) }
    }

    fun removeAllPreferences() {
        preferences.removeAllPreference()
    }
}