package com.itzik.alkotzer.aidoc.actions

import android.view.View
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import com.itzik.alkotzer.aidoc.helpers.SharedPrefHelper
import com.itzik.alkotzer.aidoc.model.ActionType

class AnimationAction(sharedPrefHelper: SharedPrefHelper) : BaseAction(ActionType.ANIMATION, sharedPrefHelper){
    override fun activate(view: View) {
        super.activate(view)
        val animSet = AnimationSet(true)
        animSet.interpolator = DecelerateInterpolator()
        animSet.fillAfter = true
        animSet.isFillEnabled = true

        val animRotate = RotateAnimation(
            0.0f, 360f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        animRotate.duration = 1000
        animRotate.fillAfter = true
        animSet.addAnimation(animRotate)

        view.startAnimation(animSet)

    }

}