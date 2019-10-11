package com.example.androidcapstone.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidcapstone.R
import com.example.androidcapstone.model.datasource.remote.network.retrofit.RetrofitHelper
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStats
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStatsResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    //Toolbar on top with OWL name and logo, sometimes action buttons
    //Some kind of horizontal navigation bar and changes between tabs
    //Featured Content
    //Ad banner at the bottom

    //Navigation menu on the left to choose overall information type


    //Login Activity
    //Home Fragment - news - videos - photos?
    //League Fragment - teams - standings - rankings
    //Players Fragment - players - players stats - hall of fame
    //Tickets
    //Social Media
    //Merch Store - WebView or Browser Redirect
    //FeedbackFragment - simple form to an RTD
    //Settings - notification preferences, permission settings, privacy policy, version

    private val firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var retrofitHelper = RetrofitHelper()
        var list = retrofitHelper.getService().getPlayerStats()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<PlayerStatsResponse> {
                lateinit var playerStatsResponse: PlayerStatsResponse
                override fun onComplete() {printHighest(playerStatsResponse.data)}

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(t: PlayerStatsResponse) { playerStatsResponse = t}

                override fun onError(e: Throwable) {}
            })
    }

    override fun onStop() {
        val user = intent.extras!!.getParcelable<FirebaseUser>("user")
        if(user!!.isAnonymous){
            user.delete()
        }
        super.onStop()
    }

    fun printHighest(list : List<PlayerStats>?){
        var player = list!![0]
        var deathCount = player.deathsAvgPer10m

        list?.forEach{
            if(it.deathsAvgPer10m > deathCount) {
                player = it
                deathCount = it.deathsAvgPer10m
            }
            Log.d("TAG_PLAYERS", "$it")
        }

        tvTest.text = player.name
    }
}
