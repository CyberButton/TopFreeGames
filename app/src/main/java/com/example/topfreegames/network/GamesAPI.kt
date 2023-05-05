package com.example.topfreegames.network

import com.example.topfreegames.model.Game
import kotlinx.serialization.descriptors.PrimitiveKind
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesAPI {
    @GET("/api/games")
    suspend fun GetGames(): List<Game>

//    @GET("/api/game")
//    suspend fun GetGameById(
//        @Query("id") id : Int
//    ) : Game

}