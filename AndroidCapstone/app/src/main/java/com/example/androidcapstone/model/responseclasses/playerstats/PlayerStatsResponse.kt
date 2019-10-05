package com.example.androidcapstone.model.responseclasses.playerstats

import com.google.gson.annotations.SerializedName

class PlayerStatsResponse {

    @SerializedName("data")
    var data: List<PlayerStats>? = null

    override fun toString(): String {
        return "PlayerStatsResponse{" +
                "data = '" + data + '\''.toString() +
                "}"
    }
}