package com.practice.practicamovil2.ui.activities

import android.app.Application
import com.practice.practicamovil2.domain.localRepositoryModule
import com.practice.practicamovil2.domain.remoteRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(remoteRepositoryModule)
        }
    }
}