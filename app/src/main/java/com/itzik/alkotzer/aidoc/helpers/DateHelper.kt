package com.itzik.alkotzer.aidoc.helpers

import java.util.*

class DateHelper {

    fun isPassPeriod(coolingPeriod : Int, lastTimeActivate: Date?) : Boolean{
        if (lastTimeActivate == null) return true
        val coolingEndAt = lastTimeActivate.time + coolingPeriod
        return coolingEndAt < Date().time

    }
}