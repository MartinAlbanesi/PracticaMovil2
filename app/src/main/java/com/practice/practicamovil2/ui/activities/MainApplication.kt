package com.practice.practicamovil2.ui.activities

import android.app.Application
import com.practice.practicamovil2.injectDependencies.localRepositoryModule
import com.practice.practicamovil2.injectDependencies.remoteRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(remoteRepositoryModule)
        }
    }
}