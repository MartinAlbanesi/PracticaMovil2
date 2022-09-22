package com.practice.practicamovil2.data.api

import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.domain.model.APIGameModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GameAPIRepository(gameAPIProvider: GameAPIProvider) : GameRepository {
    private val gameAPI: GameAPI = gameAPIProvider.getAPI()

    override suspend fun listGames(): List<APIGameModel> {
        val apiGameResponse = gameAPI.getGames()
        if(!apiGameResponse.isSuccessful){
            throw Exception("Not Found")
        }

        return apiGameResponse.body() ?: listOf()
    }




}