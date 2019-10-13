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
import com.example.androidcapstone.databinding.FragmentTeamsListBinding
import com.example.androidcapstone.model.responseclasses.teams.DataItem
import com.example.androidcapstone.view.adapters.TeamsListAdapter
import com.example.androidcapstone.viewmodel.TeamsListViewModel
import kotlinx.android.synthetic.main.fragment_teams_list.*

class TeamsListFragment : Fragment() {

    private lateinit var binder : FragmentTeamsListBinding
    private val viewModel = TeamsListViewModel()
    private val adapter = TeamsListAdapter(emptyList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_teams_list, container, false)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvTeams.layoutManager = LinearLayoutManager(context)
        rvTeams.adapter = adapter

        viewModel.teamsList.observe(this, Observer<List<DataItem?>> { t -> adapter.onTeamsListUpdate(t) })

        super.onViewCreated(view, savedInstanceState)
    }

}
