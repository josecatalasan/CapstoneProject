package com.example.androidcapstone.model.datasource.remote.network.retrofit

class OwlApi_Constants {
    companion object{
        const val BASE_URL = "https://api.overwatchleague.com/"
        const val PATH_TEAMS = "v2/teams"   // /{id} for specific
        const val PATH_STANDINGS = "v2/standings"
        const val PATH_RANKINGS = "rankings"
        const val PATH_STREAM_STATUS = "v2/streams"
        const val PATH_PLAYER_STATS = "stats/players"
        const val PATH_PLAYERS = "players" // /{id} for specific player
        const val PATH_MAPS = "maps"
        const val PATH_NEWS = "/news" // /{id} for specific
        const val LOGIN = "/login"
    }
}