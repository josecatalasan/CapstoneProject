package com.example.androidcapstone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStats
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStatsResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PlayersStatsViewModel : ViewModel() {

    val playerStatsList : MutableLiveData<List<PlayerStats?>> = MutableLiveData()

    init{
        RetrofitHelper().getService().getPlayerStats()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<PlayerStatsResponse> {
                private lateinit var response : PlayerStatsResponse
                override fun onComplete() {playerStatsList.postValue(response.data)}

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: PlayerStatsResponse) {response = t}

                override fun onError(e: Throwable) {}
            })
    }
}