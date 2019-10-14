package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.teams.PlayersItem
import com.example.androidcapstone.view.adapters.TeamsPlayersAdapter
import kotlinx.android.synthetic.main.fragment_teams_players.*

private const val PLAYERS = "players"
private const val TEAM_NAME = "team_name"
private const val DIVISION = "division"

class TeamsPlayersFragment : Fragment() {
    private var players : List<PlayersItem?>? = null
    private var teamName : String? = null
    private var division : String? = null

    companion object {
        @JvmStatic
        fun newInstance(players : List<PlayersItem?>, teamName : String?, division : String?) =
            TeamsPlayersFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(PLAYERS, players as ArrayList<PlayersItem?>)
                    putString(TEAM_NAME, teamName)
                    putString(DIVISION, division)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            players = it.getParcelableArrayList(PLAYERS)
            teamName = it.getString(TEAM_NAME)
            division = it.getString(DIVISION)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_teams_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvTeamPlayersName.text = teamName
        tvTeamPlayersDivision.text = division

        rvTeamPlayers.layoutManager = LinearLayoutManager(context)
        rvTeamPlayers.adapter = TeamsPlayersAdapter(players!!)
        super.onViewCreated(view, savedInstanceState)
    }
}
