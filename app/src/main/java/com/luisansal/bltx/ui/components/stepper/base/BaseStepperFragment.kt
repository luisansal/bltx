package com.luisansal.bltx.ui.components.stepper.base

import com.luisansal.bltx.common.BaseFragment

abstract class BaseStepperFragment : BaseFragment() {

    open val requireValidation : Boolean = false
    open var isValidated : Boolean = false

}