package com.practice.practicamovil2.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.practicamovil2.data.api.GameAPIRepository
import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.domain.model.APIGameModel
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val gameList: GameAPIRepository): ViewModel()  {

    var allGamesList = listOf<APIGameModel>()
    var errorMessage = MutableLiveData("Error")

    suspend fun fill(){
        viewModelScope.launch {
            try{
                allGamesList = gameList.getGames().body()!!
            }catch (e: Exception){
                errorMessage.value = e.message
            }
        }
    }
}
