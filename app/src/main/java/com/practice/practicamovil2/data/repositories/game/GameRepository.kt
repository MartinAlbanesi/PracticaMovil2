package com.practice.practicamovil2.data.repositories.game

import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    suspend fun listGames(): Flow<List<APIGameModel>>
}