/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.WindowCompat

object ExtensionFunctions {

    fun Activity.setTransparentStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
    }

    fun View.changeVisibility(visibility: Int) {
        val motionLayout = parent as MotionLayout
        motionLayout.constraintSetIds.forEach {
            val constraintSet = motionLayout.getConstraintSet(it) ?: return@forEach
            constraintSet.setVisibility(this.id, visibility)
            constraintSet.applyTo(motionLayout)
        }
    }

}