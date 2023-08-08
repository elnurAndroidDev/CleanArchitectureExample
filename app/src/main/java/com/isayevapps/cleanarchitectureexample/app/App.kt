package com.isayevapps.cleanarchitectureexample.app

import android.app.Application
import com.isayevapps.cleanarchitectureexample.di.appModule
import com.isayevapps.cleanarchitectureexample.di.dataModule
import com.isayevapps.cleanarchitectureexample.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}