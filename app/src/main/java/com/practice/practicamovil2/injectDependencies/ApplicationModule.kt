package com.practice.practicamovil2.injectDependencies

import com.practice.practicamovil2.data.repositories.game.api.GameAPIProvider
import com.practice.practicamovil2.data.repositories.game.api.GameAPIMainProvider
import com.practice.practicamovil2.data.repositories.game.GameAPIRepository
import com.practice.practicamovil2.data.repositories.game.GameFakeRepository
import com.practice.practicamovil2.data.repositories.game.GameRepository
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