package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.androidcapstone.R
import com.example.androidcapstone.view.adapters.TeamsPagerAdapter
import kotlinx.android.synthetic.main.fragment_teams.*

class TeamsFragment : Fragment() {

    private lateinit var pagerAdapter : TeamsPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerAdapter = TeamsPagerAdapter(childFragmentManager)
        pager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(pager)
    }

}
