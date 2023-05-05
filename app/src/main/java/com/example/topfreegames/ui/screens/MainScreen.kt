package com.example.topfreegames.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.topfreegames.model.Game


@Composable
fun MainScreen(
    gamesUiState: GamesUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (gamesUiState) {
        is GamesUiState.Loading -> LoadingScreen(modifier)
        is GamesUiState.Success -> AmphibiansListScreen(gamesUiState.amphibians, modifier)
        else -> ErrorScreen(retryAction, modifier)
    }
}

/**
 * The home screen displaying the loading message.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        //LoadingScreen()
    }
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("error")
        Button(onClick = retryAction) {
            Text("Retry")
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AmphibianCard(game: Game, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(modifier = modifier.fillMaxWidth()
        //.clickable { onClick }
            ,
        onClick = onClick,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = game.title,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = game.short_description,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(game.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                //error = ,
                //placeholder =
            )
        }
    }
}

@Composable
private fun AmphibiansListScreen(games: List<Game>, modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(

            items = games,
            key = { game ->
                game.id
            }
        ) { game ->
            AmphibianCard(game = game,
            onClick = {
                    val urlIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(game.game_url)
                    )
                    ctx.startActivity(urlIntent)
            })
        }
    }
}