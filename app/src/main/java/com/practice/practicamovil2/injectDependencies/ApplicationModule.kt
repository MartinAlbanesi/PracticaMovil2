package com.practice.practicamovil2.domain

import com.practice.practicamovil2.data.network.GameApi
import com.practice.practicamovil2.data.repositories.GameAPIClient
import com.practice.practicamovil2.data.repositories.GameFakeRepository
import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteRepositoryModule = module {
    single { GameAPIClient() }

    //ViewModel
    viewModel { MainViewModel (get()) }
}

val localRepositoryModule = module {
    single<GameRepository> { GameFakeRepository() }

    //ViewModel
    viewModel { MainViewModel (get()) }
}