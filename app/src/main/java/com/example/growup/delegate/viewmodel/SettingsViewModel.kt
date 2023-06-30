package com.example.growup.delegate.viewmodel

import androidx.lifecycle.ViewModel
import com.example.growup.delegate.data.SettingsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(private val store: SettingsRepository) : ViewModel() {

    var name = store.name
    var switcher = store.switcher
    var seekBar = store.seekBar

    fun save() {
        CoroutineScope(Dispatchers.Main).launch {
            store.name = name
            store.switcher = switcher
            store.seekBar = seekBar
        }
    }
}