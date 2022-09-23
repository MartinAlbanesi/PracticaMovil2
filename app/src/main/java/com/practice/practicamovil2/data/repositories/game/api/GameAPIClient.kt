package com.practice.practicamovil2.data.repositories.game.api

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import com.practice.practicamovil2.data.repositories.game.api.models.ErrorMessage
import retrofit2.Response

class GameAPIClient(gameAPIProvider: GameAPIProvider) : GameClient {
    private val gameAPI: GameAPI = gameAPIProvider.getAPI()

    override suspend fun fetchGames(): List<APIGameModel> {
        val apiGameResponse = gameAPI.getGames()
        if (!apiGameResponse.isSuccessful) {
            throw Exception(handleUnsuccessfulResponse(apiGameResponse).statusMessage)
        }

        return apiGameResponse.body() ?: listOf()
    }

    private fun <T> handleUnsuccessfulResponse(response: Response<T>): ErrorMessage {
        return try {
            Gson().fromJson(response.errorBody()!!.string(), ErrorMessage::class.java)
        } catch (je: JsonSyntaxException) {
            ErrorMessage(500, "Unknown")
        }
    }
}