package com.itzik.alkotzer.aidoc.actions

import android.util.Log
import com.itzik.alkotzer.aidoc.helpers.DateHelper
import com.itzik.alkotzer.aidoc.helpers.SharedPrefHelper
import com.itzik.alkotzer.aidoc.model.ActionType
import com.itzik.alkotzer.aidoc.model.ConfigurationRepository

private const val TAG = "ActionsFactory"
class ActionsFactory(private val configurationRepository: ConfigurationRepository,
                     private val sharedPrefHelper: SharedPrefHelper,
                     private val dateHelper: DateHelper) {

    fun getAction() : Action{
        val configuration = configurationRepository.configurations?: return InvalidAction()

        val action = configuration.filter { it.enabled }
            .sortedBy { it.priority }
            .firstOrNull {
                dateHelper.isPassPeriod(it.cool_down, sharedPrefHelper.getActionLastPreformed(it.type)) }?: return InvalidAction()
        Log.d(TAG, "getAction(), ${action.type}")

        return when (action.type){
            ActionType.ANIMATION -> AnimationAction(sharedPrefHelper)
            ActionType.TOAST -> ToastAction(sharedPrefHelper)
            ActionType.NOTIFICATION ->  NotificationAction(sharedPrefHelper)
        }

    }
}