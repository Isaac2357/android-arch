package com.example.daggerproject

import android.app.Application
import com.example.daggerproject.di.AppComponent
import com.example.daggerproject.di.DaggerAppComponent

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