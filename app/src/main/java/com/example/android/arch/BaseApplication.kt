package com.example.android.arch

import android.app.Application
import com.example.android.arch.di.AppComponent
import com.example.android.arch.di.DaggerAppComponent

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}