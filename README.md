# TopFreeGames
This app is intended to provide user with a list of top free games from www.freetogame.com using thier official API.
Mobile app is designed to be a more convinent way to interact with a given database of games.
(Also I made each game in list clickable, so that if user likes a game he can directly go to its webpage)

![topfreeg](https://user-images.githubusercontent.com/67738637/236890981-d38ce28f-1695-4369-a5f0-2515ce74ca9b.gif)

## Tech stack

Minimum SDK level 21

100% Kotlin based + Coroutines for asynchronous.

## JetPack

Compose - A modern toolkit for building native Android UI.

Lifecycle - dispose observing data when lifecycle state changes.

ViewModel - UI related data holder, lifecycle aware.

## Architecture

MVVM Architecture (Declarative View - ViewModel - Model)

Repository pattern

Material Design 

Retrofit2 & OkHttp3 - construct the REST APIs and load network data.
