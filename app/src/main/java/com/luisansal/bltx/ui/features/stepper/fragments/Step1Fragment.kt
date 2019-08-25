package com.luisansal.bltx.ui.features.stepper.fragments

import android.os.Bundle
import android.view.View
import com.luisansal.bltx.R
import com.luisansal.bltx.ui.components.stepper.base.BaseStepperFragment

class Step1Fragment : BaseStepperFragment() {

    override fun getLayout() = R.layout.fragment_step1

    override val requireValidation: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}