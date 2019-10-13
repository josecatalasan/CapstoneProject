package com.example.androidcapstone.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.androidcapstone.R
import com.example.androidcapstone.model.responseclasses.playerstats.PlayerStats
import com.example.androidcapstone.view.fragments.NewsFragment
import com.example.androidcapstone.view.fragments.PlayersFragment
import com.example.androidcapstone.view.fragments.TeamsFragment
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.nav_header.view.*

class HomeActivity : AppCompatActivity() {
    //Toolbar on top with OWL name and logo, sometimes action buttons
    //Some kind of horizontal navigation bar and changes between tabs
    //Featured Content
    //Ad banner at the bottom

    //Navigation menu on the left to choose overall information type

    //News Fragment - news - videos - photos?
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

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_FragmentContainer, NewsFragment.newInstance()).commit()
            navView.setCheckedItem(R.id.nav_news)
            toolbar.title = "News"
        }
        setSupportActionBar(toolbar)
        setupNavView()
    }

    override fun onStop() {
        val user = intent.extras!!.getParcelable<FirebaseUser>("user")
        if(user!!.isAnonymous){
            user.delete()
        }
        super.onStop()
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    private fun setupNavView(){
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //set user name in nav header
        val user = intent.extras!!.getParcelable<FirebaseUser>("user")!!
        navView.getHeaderView(0).navHeaderName.text = user.displayName

        //setup navigationItemSelectedListener
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_news -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_FragmentContainer, NewsFragment.newInstance()).commit()
                    toolbar.title = "News"}
                R.id.nav_teams -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_FragmentContainer, TeamsFragment()).commit()
                    toolbar.title = "Teams"}
                R.id.nav_players -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_FragmentContainer, PlayersFragment()).commit()
                    toolbar.title = "Players"}
                R.id.nav_tickets -> {}
                R.id.nav_store -> {}
                R.id.nav_share -> {}
                R.id.nav_feedback -> {}
                R.id.nav_logout -> {
                    firebaseAuth.signOut()
                    LoginManager.getInstance().logOut()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }
}
