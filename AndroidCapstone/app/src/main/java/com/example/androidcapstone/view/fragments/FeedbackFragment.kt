package com.example.androidcapstone.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.androidcapstone.R
import com.example.androidcapstone.databinding.FragmentFeedbackBinding
import com.example.androidcapstone.viewmodel.FeedbackViewModel


class FeedbackFragment : Fragment() {
    private lateinit var binder : FragmentFeedbackBinding
    private val viewModel = FeedbackViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_feedback, container, false)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return binder.root
    }

}
