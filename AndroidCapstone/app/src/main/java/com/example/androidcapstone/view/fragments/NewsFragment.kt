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
import com.example.androidcapstone.databinding.FragmentNewsBinding
import com.example.androidcapstone.model.responseclasses.newsposts.BlogsItem
import com.example.androidcapstone.view.adapters.NewsListAdapter
import com.example.androidcapstone.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {
    private lateinit var binder : FragmentNewsBinding
    private val viewModel : NewsViewModel = NewsViewModel()
    private val adapter = NewsListAdapter(emptyList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvNews.layoutManager = LinearLayoutManager(context)
        rvNews.adapter = adapter

        viewModel.newsList.observe(this, Observer<List<BlogsItem?>> { t -> adapter.onNewsUpdate(t) })

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}
