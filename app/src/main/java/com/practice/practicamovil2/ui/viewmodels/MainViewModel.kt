package com.practice.practicamovil2.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.practicamovil2.data.api.GameAPIRepository
import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.domain.model.APIGameModel
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val gameList: GameRepository): ViewModel()  {

    var allGamesList = listOf<APIGameModel>()
    var errorMessage = MutableLiveData("Error")

    suspend fun fill(){
        Log.d("MainViewModel","Entró al método fill()")
        viewModelScope.launch {
            Log.d("MainViewModel","Entró a launch de la corrutina")
            try{
                allGamesList = gameList.listGames()
                Log.d("MainViewModel","Se ejecutó el try")
            }catch (e: Exception){
                errorMessage.value = e.message
                Log.d("MainViewModel","Catcheo un error en fill()")
            }
        }
    }
}
