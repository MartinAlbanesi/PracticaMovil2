package com.practice.practicamovil2.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.practicamovil2.data.repositories.game.GameRepository
import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import com.practice.practicamovil2.ui.components.ErrorMessage
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val gameList: GameRepository) : ViewModel() {

    var allGamesList = MutableLiveData(listOf(APIGameModel("Fill", "fill", "fill")))
    var errorMessage = MutableLiveData(ErrorMessage(false, ""))

    suspend fun fill() {
        viewModelScope.launch {
            gameList.listGames()
                .catch { exception -> errorMessage.value = ErrorMessage(true, exception.message) }
                .collect { gameList ->
                    allGamesList.value = gameList
                }
        }
    }
}
