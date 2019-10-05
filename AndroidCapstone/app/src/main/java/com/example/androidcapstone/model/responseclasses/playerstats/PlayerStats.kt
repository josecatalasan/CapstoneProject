package com.example.androidcapstone.model.responseclasses.playerstats

import com.google.gson.annotations.SerializedName

class PlayerStats {

    @SerializedName("healing_avg_per_10m")
    var healingAvgPer10m: Double = 0.toDouble()

    @SerializedName("role")
    var role: String? = null

    @SerializedName("teamId")
    var teamId: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("eliminations_avg_per_10m")
    var eliminationsAvgPer10m: Double = 0.toDouble()

    @SerializedName("final_blows_avg_per_10m")
    var finalBlowsAvgPer10m: Double = 0.toDouble()

    @SerializedName("hero_damage_avg_per_10m")
    var heroDamageAvgPer10m: Double = 0.toDouble()

    @SerializedName("team")
    var team: String? = null

    @SerializedName("deaths_avg_per_10m")
    var deathsAvgPer10m: Double = 0.toDouble()

    @SerializedName("time_played_total")
    var timePlayedTotal: Double = 0.toDouble()

    @SerializedName("playerId")
    var playerId: Int = 0

    @SerializedName("ultimates_earned_avg_per_10m")
    var ultimatesEarnedAvgPer10m: Double = 0.toDouble()

    override fun toString(): String {
        return "PlayerStats{" +
                "healing_avg_per_10m = '" + healingAvgPer10m + '\''.toString() +
                ",role = '" + role + '\''.toString() +
                ",teamId = '" + teamId + '\''.toString() +
                ",name = '" + name + '\''.toString() +
                ",eliminations_avg_per_10m = '" + eliminationsAvgPer10m + '\''.toString() +
                ",final_blows_avg_per_10m = '" + finalBlowsAvgPer10m + '\''.toString() +
                ",hero_damage_avg_per_10m = '" + heroDamageAvgPer10m + '\''.toString() +
                ",team = '" + team + '\''.toString() +
                ",deaths_avg_per_10m = '" + deathsAvgPer10m + '\''.toString() +
                ",time_played_total = '" + timePlayedTotal + '\''.toString() +
                ",playerId = '" + playerId + '\''.toString() +
                ",ultimates_earned_avg_per_10m = '" + ultimatesEarnedAvgPer10m + '\''.toString() +
                "}"
    }
}