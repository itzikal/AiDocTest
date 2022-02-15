package com.itzik.alkotzer.aidoc.model

data class Configuration(
    val cool_down: Int,
    val enabled: Boolean,
    val priority: Int,
    val type: ActionType,
    val valid_days: List<Int>
)

