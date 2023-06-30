package com.example.growup.delegate.data

import android.content.SharedPreferences

class SettingsRepository(preferences: SharedPreferences) {

    var switcher: Boolean by preferences.booleanDelegate(false)
    var seekBar: Float by preferences.floatDelegate(0f)
    var name: String? by preferences.stringDelegate("")
}