package com.luisansal.bltx.ui.features.stepper.base

import com.luisansal.bltx.common.BaseFragment

abstract class BaseStepperFragment : BaseFragment() {

    open val requireValidation : Boolean = false
    open var isValidated : Boolean = false

}