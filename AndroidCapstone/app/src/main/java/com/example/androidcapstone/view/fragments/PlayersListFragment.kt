package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.androidcapstone.R
import com.example.androidcapstone.databinding.FragmentPlayersListBinding
import com.example.androidcapstone.model.responseclasses.players.ContentItem
import com.example.androidcapstone.view.adapters.PlayersListAdapter
import com.example.androidcapstone.viewmodel.PlayersListViewModel
import kotlinx.android.synthetic.main.fragment_players_list.*

class PlayersListFragment : Fragment() {

    private lateinit var binder : FragmentPlayersListBinding
    private val viewModel = PlayersListViewModel()
    private val adapter = PlayersListAdapter(emptyList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_players_list, container, false)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvPlayers.layoutManager = GridLayoutManager(context, 2)
        rvPlayers.adapter = adapter

        viewModel.playersList.observe(this, Observer<List<ContentItem?>> { t -> adapter.onPlayersListUpdate(t) })
        viewModel.getPlayers(context!!)

        super.onViewCreated(view, savedInstanceState)
    }

}
