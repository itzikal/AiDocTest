package com.itzik.alkotzer.aidoc.actions

import android.app.PendingIntent
import android.content.Intent
import android.view.View
import com.itzik.alkotzer.aidoc.MainActivity
import com.itzik.alkotzer.aidoc.helpers.NotificationsHelper
import com.itzik.alkotzer.aidoc.helpers.SharedPrefHelper
import com.itzik.alkotzer.aidoc.model.ActionType

class NotificationAction(sharedPrefHelper: SharedPrefHelper) : BaseAction(ActionType.NOTIFICATION, sharedPrefHelper){
    override fun activate(view: View) {
        super.activate(view)
        val context = view.context

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 1100, intent, PendingIntent.FLAG_IMMUTABLE)

        NotificationsHelper().sendNotification(context, "Itzik AiDoc Test", "Action Notification!", pendingIntent)

    }
}