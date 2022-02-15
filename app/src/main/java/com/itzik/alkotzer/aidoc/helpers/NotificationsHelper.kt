package com.itzik.alkotzer.aidoc.helpers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.itzik.alkotzer.aidoc.R

private const val NOTIFICATION_CHANNEL_ID = "10011"
private const val NOTIFICATION_CHANNEL_NAME = "AiDocItzikTest"

private const val TAG = "NotificationsHelper"

class NotificationsHelper {


        private fun createNotificationChannelIfNeeded(notificationManager: NotificationManager) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && notificationManager.getNotificationChannel(
                    NOTIFICATION_CHANNEL_ID
                ) == null) {

                val notificationChannel = NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    NOTIFICATION_CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationChannel.setShowBadge(false)
                notificationChannel.enableLights(true)
                notificationChannel.enableVibration(true)
                notificationChannel.vibrationPattern = longArrayOf(0, 1000, 1000)
                notificationManager.createNotificationChannel(notificationChannel)
            }
        }

        fun sendNotification(
            context: Context,
            title: String,
            message: String,
            intent: PendingIntent
        ) {
            try {
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                createNotificationChannelIfNeeded(notificationManager)

                val notificationBuilder =
                    NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setStyle(NotificationCompat.BigTextStyle())
                        .setGroup("GROUP")
                        .setAutoCancel(true)
                        .setContentIntent(intent)
                        .setSmallIcon(R.drawable.ic_launcher_foreground, 1)
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)


                notificationManager.notify(1230, notificationBuilder.build())
            } catch (ex: Exception) {
                Log.e(TAG, ex.message.toString(), ex)
            }
        }



}