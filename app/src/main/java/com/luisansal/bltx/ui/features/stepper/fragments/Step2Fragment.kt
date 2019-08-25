package com.luisansal.bltx.ui.features.stepper.fragments

import android.os.Bundle
import android.view.View
import com.luisansal.bltx.R
import com.luisansal.bltx.ui.components.stepper.base.BaseStepperFragment
import kotlinx.android.synthetic.main.fragment_step2.*

class Step2Fragment : BaseStepperFragment(){

    override fun getLayout() = R.layout.fragment_step2

    override val requireValidation: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chkValidate.setOnClickListener {
            isValidated = chkValidate.isChecked
        }
    }
}