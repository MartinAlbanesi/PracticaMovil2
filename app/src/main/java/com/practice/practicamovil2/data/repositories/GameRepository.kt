package com.practice.practicamovil2.data.repositories

import com.practice.practicamovil2.domain.model.GameModel

interface GameRepository {
    fun listGames(): List<GameModel>

}