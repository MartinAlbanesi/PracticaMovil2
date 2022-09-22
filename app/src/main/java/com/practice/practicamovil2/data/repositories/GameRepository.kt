package com.practice.practicamovil2.data.repositories

import com.practice.practicamovil2.domain.model.APIGameModel

interface GameRepository {
    suspend fun listGames(): List<APIGameModel>

}