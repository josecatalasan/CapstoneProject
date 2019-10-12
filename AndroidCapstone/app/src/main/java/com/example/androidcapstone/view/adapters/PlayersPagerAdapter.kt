package com.example.androidcapstone.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.androidcapstone.view.fragments.*

class PlayersPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {return  PlayersListFragment() }
            1 -> {return  PlayersStatsFragment() }
        }
        return Fragment() // should never reach here
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Players"
            1 -> return "Stats"
        }
        return "NONE" // should never reach here
    }
}