package com.practice.practicamovil2.domain

import com.practice.practicamovil2.data.GameFakeRepository
import com.practice.practicamovil2.data.GameRepository
import com.practice.practicamovil2.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val remoteRepositoryModule = module {  }
val localRepositoryModule = module {
    single<GameRepository> { GameFakeRepository() }
    viewModel { MainViewModel (get()) }
}