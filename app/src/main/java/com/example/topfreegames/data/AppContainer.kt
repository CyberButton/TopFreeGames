package com.example.topfreegames.data

import com.example.topfreegames.network.GamesAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

interface AppContainer {
    val gamesRepository : GamesRepository
}

class DeafultAppContainer() : AppContainer{

    private val BASE_URL =
        "https://www.freetogame.com/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: GamesAPI by lazy {
        retrofit.create(GamesAPI::class.java)
    }

    override val gamesRepository: GamesRepository by lazy {
        DefaultGamesRepository(retrofitService)
    }

}