package com.example.topfreegames.data

import com.example.topfreegames.model.Game
import com.example.topfreegames.network.GamesAPI

interface GamesRepository {
    suspend fun getGamesList(): List<Game>
//    suspend fun getGameDetail(id: Int): Game
}

class DefaultGamesRepository(
    private val GamesApi : GamesAPI
) : GamesRepository {
    override suspend fun getGamesList(): List<Game> {
        return GamesApi.GetGames()
    }

//    override suspend fun getGameDetail(id: Int): Game {
//        return GamesApi.GetGameById(id)
//    }

}