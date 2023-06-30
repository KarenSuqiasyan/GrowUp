package com.example.growup.delegate.di

import android.content.Context
import androidx.activity.ComponentActivity
import com.example.growup.delegate.ui.DelegateActivity
import com.example.growup.delegate.data.SettingsRepository
import com.example.growup.delegate.viewmodel.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun delegateModule(context: Context) = module {
    single { SettingsRepository(get()) }
    single { context.getSharedPreferences("delegates", ComponentActivity.MODE_PRIVATE) }
    viewModel { SettingsViewModel(get()) }
}
