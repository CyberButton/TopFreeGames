package com.example.topfreegames

import android.app.Application
import com.example.topfreegames.data.AppContainer
import com.example.topfreegames.data.DeafultAppContainer

class FreeGamesApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DeafultAppContainer()
    }
}