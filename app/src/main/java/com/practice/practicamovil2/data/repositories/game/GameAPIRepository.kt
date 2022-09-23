package com.practice.practicamovil2.data.repositories.game

import com.practice.practicamovil2.data.repositories.game.api.GameClient
import com.practice.practicamovil2.data.repositories.game.api.models.APIGameModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameAPIRepository(private val gameClient: GameClient) : GameRepository {
    private val games: Flow<List<APIGameModel>> = flow {
        emit(gameClient.fetchGames())
    }

    override suspend fun listGames(): Flow<List<APIGameModel>> {
        return games
    }
}