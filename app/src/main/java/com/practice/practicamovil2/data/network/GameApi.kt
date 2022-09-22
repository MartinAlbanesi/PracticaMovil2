package com.practice.practicamovil2.data.network

import com.practice.practicamovil2.data.repositories.GameRepository
import com.practice.practicamovil2.domain.model.GameResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GameApi {
    @GET("game")
    suspend fun getGames(): Response<GameResponse>
}