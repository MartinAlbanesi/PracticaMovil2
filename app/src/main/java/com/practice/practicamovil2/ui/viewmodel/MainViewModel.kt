package com.practice.practicamovil2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.practicamovil2.data.GameFakeRepository
import com.practice.practicamovil2.data.GameRepository
import com.practice.practicamovil2.data.model.GameModel


class MainViewModel(private val gameRepository: GameRepository): ViewModel()  {

    var gamesList = MutableLiveData(listOf<GameModel>())

    fun fill(){
        gamesList.value = gameRepository.listGames()
    }
}
