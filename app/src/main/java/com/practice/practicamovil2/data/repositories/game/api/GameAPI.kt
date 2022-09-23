package com.practice.practicamovil2.data.repositories.game.api

import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import retrofit2.Response
import retrofit2.http.GET


interface GameAPI {
    @GET("games")
    suspend fun getGames(): Response<List<APIGameModel>>
}