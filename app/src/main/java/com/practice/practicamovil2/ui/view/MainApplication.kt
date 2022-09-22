package com.practice.practicamovil2.ui.view

import android.app.Application
import android.os.Bundle
import com.practice.practicamovil2.R
import com.practice.practicamovil2.domain.localRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(localRepositoryModule)
        }
    }
}