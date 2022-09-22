package com.practice.practicamovil2.injectDependencies

import android.util.Log
import com.practice.practicamovil2.data.api.GameAPIProvider
import com.practice.practicamovil2.data.api.GameAPIMainProvider
import com.practice.practicamovil2.data.api.GameAPIRepository
import com.practice.practicamovil2.data.repositories.GameFakeRepository
import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.ui.activities.MainActivity
import com.practice.practicamovil2.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteRepositoryModule = module {
    Log.d("ApplicationModule","Entró al remoteRepositoryModule")
    single<GameAPIProvider> { GameAPIMainProvider() }
    single<GameRepository> { GameAPIRepository(get()) }

    Log.d("ApplicationModule","Se crearon los single de ambos repositorios")

    //ViewModel
    viewModel { MainViewModel (get()) }

    Log.d("ApplicationModule","Se instanció viewModel en Koin")

}

val localRepositoryModule = module {
    single<GameRepository> { GameFakeRepository() }

    //ViewModel
    viewModel { MainViewModel (get()) }
}