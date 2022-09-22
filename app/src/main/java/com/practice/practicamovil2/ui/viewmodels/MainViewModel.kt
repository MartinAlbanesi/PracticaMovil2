package com.practice.practicamovil2.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.practicamovil2.data.repositories.GameAPIClient
import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.domain.model.GameModel


class MainViewModel(private val gameList: GameAPIClient): ViewModel()  {

    var allGamesList = MutableLiveData(listOf<GameModel>())

    suspend fun fill(){
        val response = gameList.getGames()
        val games = response.body()
        if (games != null) {
            allGamesList.postValue(games.results)
        }else{
            allGamesList.postValue(mutableListOf())
        }
    }
}
