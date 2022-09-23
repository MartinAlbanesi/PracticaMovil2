package com.practice.practicamovil2.data.repositories.game.api

import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel

interface GameClientCache {
    suspend fun fetchGames(): List<APIGameModel>
}
