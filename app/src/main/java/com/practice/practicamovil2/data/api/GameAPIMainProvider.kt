package com.practice.practicamovil2.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class GameAPIMainProvider : GameAPIProvider {

    override fun getAPI(): GameAPI {
        val serviceGetGamesByAPI = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return serviceGetGamesByAPI.create(GameAPI::class.java)
    }
}