package com.example.androidcapstone.model.datasource.remote.notificationservice

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.androidcapstone.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotificationService : FirebaseMessagingService(){

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val title = remoteMessage.notification?.title
        val message = remoteMessage.notification?.body

        val builder = NotificationCompat.Builder(this, "channel")
        builder.setContentTitle(title).setContentText(message)
            .setSmallIcon(R.drawable.ic_home)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())

        super.onMessageReceived(remoteMessage)
    }
}