package com.practice.practicamovil2.data.repositories

import com.practice.practicamovil2.data.network.GameApi
import com.practice.practicamovil2.domain.model.GameResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GameAPIClient : GameApi {
    private val serviceGetGamesByAPI: GameApi = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GameApi::class.java)

    override suspend fun getGames(): Response<GameResponse> {
        return serviceGetGamesByAPI.getGames()
    }

}