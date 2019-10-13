package com.example.androidcapstone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.responseclasses.players.ContentItem
import com.example.androidcapstone.model.responseclasses.players.PlayersResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.Collections.sort

class PlayersListViewModel : ViewModel() {

    val playersList : MutableLiveData<List<ContentItem?>> = MutableLiveData()

    init{
        RetrofitHelper().getService().getPlayers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<PlayersResponse> {
                private lateinit var response : PlayersResponse

                override fun onComplete() {
                    sort(response.content as MutableList<ContentItem?>) { p0, p1 -> p0?.name!!.toLowerCase(
                        Locale.getDefault()).compareTo(p1?.name!!.toLowerCase(Locale.getDefault())) }
                    playersList.postValue(response.content)
                }

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: PlayersResponse) {response = t}

                override fun onError(e: Throwable) {}
            })
    }
}