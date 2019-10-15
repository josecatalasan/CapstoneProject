package com.example.androidcapstone.model.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.androidcapstone.view.activities.HomeActivity
import kotlinx.android.synthetic.premium.activity_home.*

class HomeBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context : Context?, intent : Intent?){

        when(intent?.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isAirplaneModeOn = intent.getBooleanExtra("state", false)
                if (isAirplaneModeOn) {
                    // handle Airplane Mode on
                    Toast.makeText(context, "On", Toast.LENGTH_SHORT).show()
                    (context as HomeActivity).navView.menu.getItem(3).isEnabled = false
                    context.navView.menu.getItem(4).subMenu.getItem(0).isEnabled = false
                    context.navView.menu.getItem(4).subMenu.getItem(1).isEnabled = false
                    context.navView.menu.getItem(5).subMenu.getItem(0).isEnabled = false
                    context.navView.menu.getItem(5).subMenu.getItem(1).isEnabled = false
                } else {
                    // handle Airplane Mode off
                    Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show()
                    (context as HomeActivity).navView.menu.getItem(3).isEnabled = true
                    context.navView.menu.getItem(4).subMenu.getItem(0).isEnabled = true
                    context.navView.menu.getItem(4).subMenu.getItem(1).isEnabled = true
                    context.navView.menu.getItem(5).subMenu.getItem(0).isEnabled = true
                    context.navView.menu.getItem(5).subMenu.getItem(1).isEnabled = true
                }
            }
        }
    }
}