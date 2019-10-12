package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.androidcapstone.R
import com.example.androidcapstone.view.adapters.PlayersPagerAdapter
import com.example.androidcapstone.view.adapters.TeamsPagerAdapter
import kotlinx.android.synthetic.main.fragment_teams.*

class PlayersFragment : Fragment() {

    private lateinit var pagerAdapter : PlayersPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerAdapter = PlayersPagerAdapter(childFragmentManager)
        pager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(pager)
    }


}
