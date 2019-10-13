package com.example.androidcapstone.model.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class HomeBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context : Context?, intent : Intent?){

        when(intent?.action){
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isAirplaneModeOn = intent.getBooleanExtra("state", false)
                if (isAirplaneModeOn) {
                    // handle Airplane Mode on
                    Toast.makeText(context, "On", Toast.LENGTH_SHORT).show()
                } else {
                    // handle Airplane Mode off
                    Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}