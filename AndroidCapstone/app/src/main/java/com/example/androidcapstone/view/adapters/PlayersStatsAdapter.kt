package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStats
import kotlinx.android.synthetic.main.item_players_stats.view.*
import java.util.*

class PlayersStatsAdapter(var playersStatsList : List<PlayerStats?>) : RecyclerView.Adapter<PlayersStatsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_players_stats, parent, false))

    override fun getItemCount(): Int = playersStatsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(playersStatsList[position])

    fun onListUpdate(list : List<PlayerStats?>){
        this.playersStatsList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(playerStats: PlayerStats?) {
            itemView.tvPlayerStatsName.text = playerStats?.name
            itemView.tvPlayerStatsRole.text = playerStats?.role?.toUpperCase(Locale.getDefault())
            itemView.tvPlayerStatsTeam.text = playerStats?.team
            itemView.tvPlayerStatsEliminations.text = String.format("%-15s: %-8.1f" , "Eliminations", playerStats?.eliminationsAvgPer10m)
            itemView.tvPlayerStatsFinalBlows.text = String.format("%-15s: %-8.1f" , "Final Blows", playerStats?.finalBlowsAvgPer10m)
            itemView.tvPlayerStatsHeroDamage.text = String.format("%-15s: %-8.1f" , "Hero Damage", playerStats?.heroDamageAvgPer10m)
            itemView.tvPlayerStatsHealing.text = String.format("%-15s: %-8.1f" , "Healing", playerStats?.healingAvgPer10m)
            itemView.tvPlayerStatsUltimates.text = String.format("%-15s: %-8.1f" , "Ultimates", playerStats?.ultimatesEarnedAvgPer10m)
            itemView.tvPlayerStatsTimePlayed.text = String.format("%-15s: %-8.1f" , "Time Players", playerStats?.timePlayedTotal)
            itemView.tvPlayerStatsDeaths.text = String.format("%-15s: %-8.1f" , "Deaths", playerStats?.deathsAvgPer10m)
        }
    }
}