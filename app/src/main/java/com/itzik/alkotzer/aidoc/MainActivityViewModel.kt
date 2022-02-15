package com.itzik.alkotzer.aidoc

import androidx.lifecycle.ViewModel
import com.itzik.alkotzer.aidoc.actions.Action
import com.itzik.alkotzer.aidoc.actions.ActionsFactory
import com.itzik.alkotzer.aidoc.extantions.SingleLiveEvent

class MainActivityViewModel(private val actionsFactory: ActionsFactory) :ViewModel() {


    sealed class AlertEvent {
        data class DoAction(val action : Action) :
            AlertEvent()
    }

    val events = SingleLiveEvent<AlertEvent>()
    fun doAction(){
        events.postValue(AlertEvent.DoAction(actionsFactory.getAction()))
    }
}