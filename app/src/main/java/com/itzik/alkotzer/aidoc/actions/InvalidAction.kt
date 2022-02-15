package com.itzik.alkotzer.aidoc.actions

import android.util.Log
import android.view.View

class InvalidAction : Action {
    override fun activate(view: View) {
        Log.e("InvalidAction", "activate(), ")
    }

}
