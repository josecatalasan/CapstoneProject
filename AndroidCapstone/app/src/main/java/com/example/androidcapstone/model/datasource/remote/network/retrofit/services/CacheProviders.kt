package com.example.androidcapstone.model.datasource.remote.network.retrofit.services

import com.example.androidcapstone.model.responseclasses.newsposts.NewsResponse
import com.example.androidcapstone.model.responseclasses.players.PlayersResponse
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStatsResponse
import com.example.androidcapstone.model.responseclasses.teams.TeamsResponse
import io.reactivex.Observable

interface CacheProviders {
    fun getNews(news : Observable<NewsResponse>) : Observable<NewsResponse>
    fun getTeams(teams : Observable<TeamsResponse>) : Observable<TeamsResponse>
    fun getPlayers(players : Observable<PlayersResponse>) : Observable<PlayersResponse>
    fun getPlayerStats(stats : Observable<PlayerStatsResponse>) : Observable<PlayerStatsResponse>
}