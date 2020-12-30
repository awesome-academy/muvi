package com.example.muvi

import android.app.Application
import com.example.muvi.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(
                listOf(
                    networkModule
                )
            )
        }
    }
}
