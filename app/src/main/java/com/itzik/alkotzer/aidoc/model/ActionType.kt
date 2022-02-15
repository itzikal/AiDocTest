package com.itzik.alkotzer.aidoc.model

import com.google.gson.annotations.SerializedName

enum class ActionType {
        @SerializedName("animation")
        ANIMATION,

        @SerializedName("notification")
        NOTIFICATION,

        @SerializedName("toast")
        TOAST,
}