package com.luisansal.bltx.ui.features.stepper

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

interface IStepperMVP {

    interface View : LifecycleOwner{
        fun setupStepper(fragments: List<Fragment>)
    }

    interface Presenter{
        fun init()
    }

}