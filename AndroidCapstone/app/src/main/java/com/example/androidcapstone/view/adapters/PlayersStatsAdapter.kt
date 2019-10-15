package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStats
import kotlinx.android.synthetic.main.item_players_stats.view.*
import java.util.*
import kotlin.Comparator

class PlayersStatsAdapter(var playersStatsList : List<PlayerStats?>) : RecyclerView.Adapter<PlayersStatsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_players_stats, parent, false))

    override fun getItemCount(): Int = playersStatsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(playersStatsList[position])

    fun onListUpdate(list : List<PlayerStats?>){
        this.playersStatsList = list
        notifyDataSetChanged()
    }

    fun sortBy(category : String){
        when(category){
            "Name" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p0?.name!!.toLowerCase(Locale.getDefault())
                    .compareTo(p1?.name!!.toLowerCase(Locale.getDefault()))
            })}
            "Eliminations" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.eliminationsAvgPer10m.compareTo(p0!!.eliminationsAvgPer10m)
            })}
            "Final Blows" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.finalBlowsAvgPer10m.compareTo(p0!!.finalBlowsAvgPer10m)
            })}
            "Hero Damage" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.heroDamageAvgPer10m.compareTo(p0!!.heroDamageAvgPer10m)
            })}
            "Healing" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.healingAvgPer10m.compareTo(p0!!.healingAvgPer10m)
            })}
            "Ultimates" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.ultimatesEarnedAvgPer10m.compareTo(p0!!.ultimatesEarnedAvgPer10m)
            })}
            "Time Played" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.timePlayedTotal.compareTo(p0!!.timePlayedTotal)
            })}
            "Deaths" -> {playersStatsList = playersStatsList.sortedWith(Comparator<PlayerStats?> { p0, p1 ->
                p1!!.deathsAvgPer10m.compareTo(p0!!.deathsAvgPer10m)
            })}
        }
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(playerStats: PlayerStats?) {
            itemView.tvPlayerStatsName.text = String.format("%-20s %s", playerStats?.name, playerStats?.team)

            when(playerStats?.role){
                "offense" -> itemView.tvPlayerStatsName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.offense_icon,0,0,0)
                "tank" -> itemView.tvPlayerStatsName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tank_icon,0,0,0)
                "support" -> itemView.tvPlayerStatsName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.support_icon,0,0,0)
            }

            itemView.tvPlayerStatsEliminations.text = String.format("%s\n%.1f" , "Eliminations", playerStats?.eliminationsAvgPer10m)
            itemView.tvPlayerStatsFinalBlows.text = String.format("%s\n%.1f" , "Final Blows", playerStats?.finalBlowsAvgPer10m)
            itemView.tvPlayerStatsHeroDamage.text = String.format("%s\n%.1f" , "Hero Damage", playerStats?.heroDamageAvgPer10m)
            itemView.tvPlayerStatsHealing.text = String.format("%s\n%.1f" , "Healing", playerStats?.healingAvgPer10m)
            itemView.tvPlayerStatsUltimates.text = String.format("%s\n%.1f" , "Ultimates", playerStats?.ultimatesEarnedAvgPer10m)
            itemView.tvPlayerStatsTimePlayed.text = String.format("%s\n%d min" , "Time Played", (playerStats?.timePlayedTotal?.div(60)?.toInt()))
            itemView.tvPlayerStatsDeaths.text = String.format("%s\n%.1f" , "Deaths", playerStats?.deathsAvgPer10m)
        }
    }
}