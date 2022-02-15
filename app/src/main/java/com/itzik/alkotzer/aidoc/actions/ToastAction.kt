package com.itzik.alkotzer.aidoc.actions

import android.view.View
import android.widget.Toast
import com.itzik.alkotzer.aidoc.helpers.SharedPrefHelper
import com.itzik.alkotzer.aidoc.model.ActionType

class ToastAction(sharedPrefHelper: SharedPrefHelper) : BaseAction(ActionType.TOAST, sharedPrefHelper) {
    override fun activate(view: View) {
        super.activate(view)
        Toast.makeText(view.context, "Action Is Toast!", Toast.LENGTH_LONG).show()
    }

}