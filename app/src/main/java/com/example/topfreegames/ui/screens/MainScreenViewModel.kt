package com.example.topfreegames.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import com.example.topfreegames.data.GamesRepository
import com.example.topfreegames.model.Game
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.topfreegames.FreeGamesApplication


/**
 * UI state for the Home screen
 */
sealed interface GamesUiState {
    data class Success(val amphibians: List<Game>) : GamesUiState
    object Error : GamesUiState
    object Loading : GamesUiState
    object Details: GamesUiState
}

class MainScreenViewModel(private val gamesRepository: GamesRepository) : ViewModel() {

    var gamesUiState: GamesUiState by mutableStateOf(GamesUiState.Loading)
        private set

    init {
        getGames()
    }

    fun getGames() {
        viewModelScope.launch {
            gamesUiState = GamesUiState.Loading
            gamesUiState = try {
                GamesUiState.Success(gamesRepository.getGamesList())
            } catch (e: IOException) {
                GamesUiState.Error
            } catch (e: HttpException) {
                GamesUiState.Error
            }
        }
    }

//    fun ShowDetails() {
//        gamesUiState = GamesUiState.Details
//    }

    /**
     * Factory for [AmphibiansViewModel] that takes [AmphibiansRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FreeGamesApplication)
                val gamesRepository = application.container.gamesRepository
                MainScreenViewModel(gamesRepository = gamesRepository)
            }
        }
    }
}