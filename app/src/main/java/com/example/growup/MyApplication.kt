package com.example.growup

import android.app.Application
import com.example.growup.delegate.di.delegateModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class MyApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun getKoinModules(): List<Module> = listOf(
        delegateModule(applicationContext)
    )

    companion object {
        lateinit var instance: MyApplication
    }
}