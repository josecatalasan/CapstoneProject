package com.example.androidcapstone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.responseclasses.teams.DataItem
import com.example.androidcapstone.model.responseclasses.teams.TeamsResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TeamsListViewModel : ViewModel() {

    val teamsList : MutableLiveData<List<DataItem?>> = MutableLiveData()

    init{
        RetrofitHelper().getService().getTeams()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<TeamsResponse> {
                private lateinit var response : TeamsResponse
                override fun onComplete() {teamsList.postValue(response.data)}

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: TeamsResponse) {response = t}

                override fun onError(e: Throwable) {}
            })
    }
}