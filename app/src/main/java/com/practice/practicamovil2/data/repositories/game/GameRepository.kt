package com.practice.practicamovil2.data.repositories.game

import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel

interface GameRepository {
    suspend fun listGames(): List<APIGameModel>

}