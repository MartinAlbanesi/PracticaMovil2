package com.practice.practicamovil2.data.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class GameAPIMainProvider : GameAPIProvider {

    override fun getAPI(): GameAPI {

        Log.d("GameAPIMainProvider","Entro al método getAPI()")

        val serviceGetGamesByAPI = Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        Log.d("GameAPIMainProvider","Se construyó Retrofit exitosamente")
        return serviceGetGamesByAPI.create(GameAPI::class.java)
    }
}