package com.practice.practicamovil2.injectDependencies

import com.practice.practicamovil2.data.repositories.game.GameCachedRepository
import com.practice.practicamovil2.data.repositories.game.GameFakeRepository
import com.practice.practicamovil2.data.repositories.game.GameRepository
import com.practice.practicamovil2.data.repositories.game.api.*
import com.practice.practicamovil2.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteRepositoryModule = module {
    single<GameAPIProvider> { GameAPIMainProvider() }
    single<GameClient> { GameAPIClient(get()) }
    single<GameClientCache> { GameFakeAPIClient() }
    single<GameRepository> { GameCachedRepository(get(), get()) }

    //ViewModel
    viewModel { MainViewModel(get()) }
}

val localRepositoryModule = module {
    single<GameRepository> { GameFakeRepository() }

    //ViewModel
    viewModel { MainViewModel(get()) }
}