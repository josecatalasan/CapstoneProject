package com.example.androidcapstone.model.datasource.remote.network.retrofit.services

import com.example.androidcapstone.model.datasource.remote.network.retrofit.OwlApi_Constants
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStatsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface OverwatchApiService {

    @GET (OwlApi_Constants.PATH_PLAYER_STATS)
    fun getPlayerStats() : Observable<PlayerStatsResponse>
}