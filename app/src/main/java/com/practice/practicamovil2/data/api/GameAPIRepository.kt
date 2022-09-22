package com.practice.practicamovil2.data.api

import android.util.Log
import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.domain.model.APIGameModel

class GameAPIRepository(gameAPIProvider: GameAPIProvider) : GameRepository {
    private val gameAPI: GameAPI = gameAPIProvider.getAPI()

    override suspend fun listGames(): List<APIGameModel> {

        Log.d("GameAPIRepository","Entro al método listGames()")
        val apiGameResponse = gameAPI.getGames()
        if(!apiGameResponse.isSuccessful){
            Log.d("GameAPIRepository","Entro a la excepcion del método listGames()")
            throw Exception("Not Found")
        }else{
            Log.d("GameAPIRepository","La Response fue SUCCESSFUL")
            return apiGameResponse.body() ?: listOf()
        }
    }




}