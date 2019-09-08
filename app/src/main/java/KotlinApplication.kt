package com.example.android.kotlin_fundamental
import android.app.Application
import timber.log.Timber

class KotlinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}