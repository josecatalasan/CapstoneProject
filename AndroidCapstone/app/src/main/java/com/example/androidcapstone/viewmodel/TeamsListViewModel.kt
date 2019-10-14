package com.example.androidcapstone.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.datasource.remote.network.retrofit.services.CacheProviders
import com.example.androidcapstone.model.responseclasses.teams.DataItem
import com.example.androidcapstone.model.responseclasses.teams.TeamsResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.rx_cache2.internal.RxCache
import io.victoralbertos.jolyglot.GsonSpeaker
import java.util.*
import java.util.Collections.sort

class TeamsListViewModel : ViewModel() {

    val teamsList : MutableLiveData<List<DataItem?>> = MutableLiveData()
    private lateinit var cacheProviders: CacheProviders

    fun getTeams(context: Context){
        cacheProviders = RxCache.Builder()
            .setMaxMBPersistenceCache(5)
            .persistence(context.filesDir, GsonSpeaker())
            .using(CacheProviders::class.java)

        cacheProviders.getTeams(RetrofitHelper().getService().getTeams())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<TeamsResponse> {
                private lateinit var response : TeamsResponse
                override fun onComplete() {
                    sort(response.data as MutableList<DataItem?>) { p0, p1 -> p0?.name!!.toLowerCase(
                        Locale.getDefault()).compareTo(p1?.name!!.toLowerCase(Locale.getDefault())) }
                    teamsList.postValue(response.data)
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: TeamsResponse) {response = t}

                override fun onError(e: Throwable) {}
            })
    }
}