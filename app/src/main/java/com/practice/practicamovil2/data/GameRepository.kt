package com.practice.practicamovil2.data

import com.practice.practicamovil2.data.model.GameModel

interface GameRepository {
    fun listGames(): List<GameModel>

}