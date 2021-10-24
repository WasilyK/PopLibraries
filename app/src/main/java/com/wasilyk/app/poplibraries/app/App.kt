package com.wasilyk.app.poplibraries.app

import android.app.Application
import android.content.Context
import com.wasilyk.app.poplibraries.di.components.AppComponent
import com.wasilyk.app.poplibraries.di.components.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
    }
}