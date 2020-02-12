package com.example.analyticsapp.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment

import com.example.analyticsapp.R
import com.example.analyticsapp.main.AnalitycsManager

class NotificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?)=
      inflater.inflate(R.layout.notification_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnalitycsManager.logEvent("OPEN_SCREEN_EVENT", mapOf("OPEN_SCREEN_EVENT" to "NOTIFICATION_FRAGMENT"))

        val message = view.findViewById<TextView>(R.id.args_edit_text)
        val notificationButton = view.findViewById<Button>(R.id.send_notification_button)

        notificationButton.setOnClickListener {
            AnalitycsManager.logEvent("CLICK_EVENT", mapOf("CLICK_EVENT" to "CLICK_NOTIFICATION_BUTTON"))

            AnalitycsManager.logEvent("CLICK_EVENT", mapOf("CLICK_EVENT" to "CLICK_NOTIFICATION_BUTTON"))
            val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationManager.createNotificationChannel(NotificationChannel(
                    CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_HIGH))
            }

            val builder = NotificationCompat.Builder(
                    context!!, CHANNEL_ID)
                    .setContentTitle("Notification Title")
                    .setContentText(message.text.toString())
                    .setSmallIcon(R.drawable.ic_android)
                    .setAutoCancel(true)
                    notificationManager.notify(0, builder.build()).also {
                        AnalitycsManager.logEvent("SEND_NOTIFICATION_EVENT", mapOf("SEND_NOTIFICATION_EVENT" to message.text.toString()))
                    }
        }
    }
}

private const val CHANNEL_ID = "chanel_id"
