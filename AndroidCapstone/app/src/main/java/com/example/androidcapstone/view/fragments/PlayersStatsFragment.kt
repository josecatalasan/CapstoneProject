package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.androidcapstone.R
import com.example.androidcapstone.databinding.FragmentPlayersStatsBinding
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStats
import com.example.androidcapstone.view.adapters.PlayersStatsAdapter
import com.example.androidcapstone.viewmodel.PlayersStatsViewModel
import kotlinx.android.synthetic.main.fragment_players_stats.*

class PlayersStatsFragment : Fragment() {

    private lateinit var binder : FragmentPlayersStatsBinding
    private val viewModel = PlayersStatsViewModel()
    private val adapter = PlayersStatsAdapter(emptyList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_players_stats, container, false)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvPlayersStats.layoutManager = LinearLayoutManager(context)
        rvPlayersStats.adapter = adapter

        viewModel.playerStatsList.observe(this, Observer<List<PlayerStats?>> { t -> adapter.onListUpdate(t) })

        super.onViewCreated(view, savedInstanceState)
    }

}
