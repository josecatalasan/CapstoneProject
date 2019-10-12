package com.example.androidcapstone.model.datasource.remote.network.retrofit.services

import com.example.androidcapstone.model.datasource.remote.network.retrofit.OwlApi_Constants.Companion.PATH_NEWS
import com.example.androidcapstone.model.datasource.remote.network.retrofit.OwlApi_Constants.Companion.PATH_PLAYERS
import com.example.androidcapstone.model.datasource.remote.network.retrofit.OwlApi_Constants.Companion.PATH_PLAYER_STATS
import com.example.androidcapstone.model.datasource.remote.network.retrofit.OwlApi_Constants.Companion.PATH_TEAMS
import com.example.androidcapstone.model.responseclasses.newsposts.NewsResponse
import com.example.androidcapstone.model.responseclasses.players.PlayersResponse
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStatsResponse
import com.example.androidcapstone.model.responseclasses.teams.TeamsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface OverwatchApiService {

    @GET(PATH_NEWS)
    fun getNews() : Observable<NewsResponse>

    @GET(PATH_TEAMS)
    fun getTeams() : Observable<TeamsResponse>

    @GET(PATH_PLAYERS)
    fun getPlayers() : Observable<PlayersResponse>

    @GET (PATH_PLAYER_STATS)
    fun getPlayerStats() : Observable<PlayerStatsResponse>

}