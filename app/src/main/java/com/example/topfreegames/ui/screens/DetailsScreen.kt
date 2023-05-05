package com.example.topfreegames.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.topfreegames.model.Game

@Composable
fun DetailsScreen(game: Game) {
    Column(modifier = Modifier.padding(16.dp)) {
        val ctx = LocalContext.current
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(game.thumbnail)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillWidth)
//        CoilImage(
//            data = game.thumbnail,
//            contentDescription = null,
//            modifier = Modifier.fillMaxWidth().aspectRatio(16f/9f)
//        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = game.title,
            style = MaterialTheme.typography.h4
        )
        Text(
            text = game.short_description,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Genre: ${game.genre}",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Platform: ${game.platform}",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Publisher: ${game.publisher}",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Developer: ${game.developer}",
            style = MaterialTheme.typography.body1
        )
        Text(
            text = "Release Date: ${game.release_date}",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                      val urlIntent = Intent(
                          Intent.ACTION_VIEW,
                          Uri.parse(game.game_url)
                      )
                ctx.startActivity(urlIntent)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Play Now")
        }
    }
}