package com.itzik.alkotzer.aidoc.helpers

import android.content.Context
import android.content.SharedPreferences
import com.itzik.alkotzer.aidoc.model.ActionType
import java.util.*

const val SHARE_PREF_FILE_NAME = "shared_pref"
class SharedPrefHelper(context: Context) {

    fun saveActionPreformed(name: ActionType, date: Date) {
        sharedPreferences.edit().putLong(name.toString(), date.time).apply()
    }

    fun getActionLastPreformed(name: ActionType) : Date? {
        val time = sharedPreferences.getLong(name.toString(), 0L)
        return if(time == 0L){
            null
        }else{
            Date(time)
        }
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARE_PREF_FILE_NAME, Context.MODE_PRIVATE)
}