package com.practice.practicamovil2.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.practicamovil2.data.repositories.game.GameRepository
import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import com.practice.practicamovil2.ui.components.ErrorMessage
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val gameList: GameRepository) : ViewModel() {

    var allGamesList = listOf<APIGameModel>()
    var errorMessage = MutableLiveData(ErrorMessage(false, ""))

    suspend fun fill() {
        viewModelScope.launch {
            try {
                allGamesList = gameList.listGames()
            } catch (e: Exception) {
                errorMessage.value = ErrorMessage(true, e.message)
            }
        }
    }
}
