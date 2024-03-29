package com.example.androidcapstone.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.players.ContentItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_players.view.*

class PlayersListAdapter(var playersList : List<ContentItem?>) : RecyclerView.Adapter<PlayersListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_players, parent, false))

    override fun getItemCount(): Int = playersList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(playersList[position])

    fun onPlayersListUpdate(list : List<ContentItem?>){
        this.playersList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(contentItem: ContentItem?) {
            Picasso.get().load(contentItem?.headshot).into(itemView.ivHeadshot)
            itemView.tvPlayerName.text = contentItem?.name
            when(contentItem?.attributes?.role){
                "offense" -> itemView.tvPlayerName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.offense_icon,0,0,0)
                "tank" -> itemView.tvPlayerName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.tank_icon,0,0,0)
                "support" -> itemView.tvPlayerName.setCompoundDrawablesWithIntrinsicBounds(R.drawable.support_icon,0,0,0)
            }
            itemView.tvPlayerRealName.text = String.format("%s %s", contentItem?.givenName, contentItem?.familyName)
            itemView.tvPlayerNumber.text = contentItem?.attributes?.playerNumber?.toString()
        }
    }
}