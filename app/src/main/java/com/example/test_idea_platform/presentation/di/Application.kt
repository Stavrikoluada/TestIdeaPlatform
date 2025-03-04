package com.example.test_idea_platform.presentation.di

import android.app.Application
import android.content.Context

class Application : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
            private set
    }
}
