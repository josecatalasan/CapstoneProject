package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.teams.DataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_teams.view.*

class TeamsListAdapter(var teamsList : List<DataItem?>) : RecyclerView.Adapter<TeamsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_teams, parent, false))

    override fun getItemCount(): Int = teamsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(teamsList[position])

    fun onTeamsListUpdate(list : List<DataItem?>){
        this.teamsList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dataItem: DataItem?) {
            Picasso.get().load(dataItem?.logo?.main?.png).into(itemView.ivLogo)
            itemView.tvTeamName.text = dataItem?.name
            //players, division
        }
    }
}