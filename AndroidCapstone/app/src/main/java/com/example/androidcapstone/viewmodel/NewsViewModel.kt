package com.example.androidcapstone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.responseclasses.newsposts.BlogsItem
import com.example.androidcapstone.model.responseclasses.newsposts.NewsResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel : ViewModel() {

    val newsList : MutableLiveData<List<BlogsItem?>> = MutableLiveData()

    init{
        //make retrofit call and post newsList
        RetrofitHelper().getService().getNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<NewsResponse>{
                private lateinit var response : NewsResponse
                override fun onComplete() {newsList.postValue(response.blogs)}

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: NewsResponse) {response = t}

                override fun onError(e: Throwable) {}
            })
    }
}