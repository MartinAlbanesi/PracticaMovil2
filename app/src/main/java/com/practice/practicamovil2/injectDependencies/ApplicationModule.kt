package com.practice.practicamovil2.injectDependencies

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
    single<GameAPIProvider> { GameAPIMainProvider() }
    single<GameRepository> { GameAPIRepository(get()) }

    //ViewModel
    viewModel { MainViewModel (get()) }
}

val localRepositoryModule = module {
    single<GameRepository> { GameFakeRepository() }

    //ViewModel
    viewModel { MainViewModel (get()) }
}