package com.example.topfreegames.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.topfreegames.ui.screens.MainScreen
import com.example.topfreegames.ui.screens.MainScreenViewModel

@Composable
fun FreeGamesApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Top Free Games")}) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val gamesViewModel: MainScreenViewModel =
                viewModel(factory = MainScreenViewModel.Factory)
            MainScreen(
                gamesUiState = gamesViewModel.gamesUiState,
                retryAction = gamesViewModel::getGames
            )
        }
    }
}