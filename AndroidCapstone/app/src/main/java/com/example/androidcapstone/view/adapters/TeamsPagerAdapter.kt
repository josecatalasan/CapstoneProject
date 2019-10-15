package com.example.androidcapstone.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.androidcapstone.view.fragments.TeamsListFragment
import com.example.androidcapstone.view.fragments.TeamsRankingsFragment

class TeamsPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, 	BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {return TeamsListFragment()}
            1 -> {return TeamsRankingsFragment()}
        }
        return Fragment() // should never reach here
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Teams"
            1 -> return "Rankings"
        }
        return "NONE" // should never reach here
    }
}