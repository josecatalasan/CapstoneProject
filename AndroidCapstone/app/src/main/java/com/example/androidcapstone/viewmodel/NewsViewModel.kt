package com.example.androidcapstone.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.datasource.remote.network.retrofit.services.CacheProviders
import com.example.androidcapstone.model.responseclasses.newsposts.BlogsItem
import com.example.androidcapstone.model.responseclasses.newsposts.NewsResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.rx_cache2.internal.RxCache
import io.victoralbertos.jolyglot.GsonSpeaker

class NewsViewModel : ViewModel() {

    val newsList : MutableLiveData<List<BlogsItem?>> = MutableLiveData()
    private lateinit var cacheProviders: CacheProviders

    fun getNews(context : Context){
        cacheProviders = RxCache.Builder()
            .setMaxMBPersistenceCache(5)
            .persistence(context.filesDir, GsonSpeaker())
            .using(CacheProviders::class.java)

        cacheProviders.getNews(RetrofitHelper().getService().getNews()).observeOn(AndroidSchedulers.mainThread())
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