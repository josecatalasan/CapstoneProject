package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

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
        setupSpinner()

        rvPlayersStats.layoutManager = GridLayoutManager(context, 2)
        rvPlayersStats.adapter = adapter
        viewModel.playerStatsList.observe(this, Observer<List<PlayerStats?>> { t -> adapter.onListUpdate(t) })
        viewModel.getPlayerStats(context!!)

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupSpinner(){
        val sortAdapter = ArrayAdapter<String>(context!!, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.sortBy))
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSortBy.adapter = sortAdapter
        spinnerSortBy.onItemSelectedListener
        spinnerSortBy.onItemSelectedListener = MyOnItemSelectedListener()
    }

    private inner class MyOnItemSelectedListener : OnItemSelectedListener{
        override fun onNothingSelected(p0: AdapterView<*>?) {}

        override fun onItemSelected(adapterView : AdapterView<*>?, view: View?, position: Int, rowId: Long) {
            val category = adapterView?.getItemAtPosition(position).toString()
            adapter.sortBy(category)
        }
    }
}
