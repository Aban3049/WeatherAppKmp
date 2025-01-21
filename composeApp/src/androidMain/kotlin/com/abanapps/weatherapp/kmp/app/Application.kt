package com.abanapps.weatherapp.kmp.app

import android.app.Application
import com.abanapps.weatherapp.kmp.di.initKoin
import com.abanapps.weatherapp.kmp.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
        }
    }

}