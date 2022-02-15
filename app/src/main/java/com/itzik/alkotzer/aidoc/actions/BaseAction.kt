package com.itzik.alkotzer.aidoc.actions

import android.view.View
import com.itzik.alkotzer.aidoc.helpers.SharedPrefHelper
import com.itzik.alkotzer.aidoc.model.ActionType
import java.util.*

abstract class BaseAction(private val name: ActionType, private val sharedPrefHelper: SharedPrefHelper) : Action {

    private fun saveActionDate(){
        sharedPrefHelper.saveActionPreformed(name , Date())
    }

    override fun activate(view: View) {
        saveActionDate()
    }
}