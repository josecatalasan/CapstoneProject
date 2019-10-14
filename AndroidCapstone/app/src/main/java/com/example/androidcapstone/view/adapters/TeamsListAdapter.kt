package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.teams.DataItem
import com.example.androidcapstone.model.responseclasses.teams.PlayersItem
import com.example.androidcapstone.view.activities.HomeActivity
import com.example.androidcapstone.view.fragments.TeamsPlayersFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_teams.view.*

class TeamsListAdapter(private var teamsList : List<DataItem?>) : RecyclerView.Adapter<TeamsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_teams, parent, false))

    override fun getItemCount(): Int = teamsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(teamsList[position])

    fun onTeamsListUpdate(list : List<DataItem?>){
        this.teamsList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var players : List<PlayersItem?>? = null
        private var teamName : String? = null
        private var division : String? = null

        fun bind(dataItem: DataItem?) {
            val pacificDivision = 80
            val atlanticDivision = 79
            players = dataItem?.players
            teamName = dataItem?.name
            when(dataItem?.divisionId){
                pacificDivision -> {division = "Pacific"}
                atlanticDivision -> {division = "Atlantic"}
            }

            Picasso.get().load(dataItem?.logo?.main?.png).into(itemView.ivLogo)
            itemView.tvTeamName.text = teamName
            itemView.tvDivision.text = division
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            (view?.context as HomeActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_FragmentContainer,
                    TeamsPlayersFragment.newInstance(players!!, teamName, division))
                .addToBackStack("TeamsPlayers").commit()
        }
    }
}