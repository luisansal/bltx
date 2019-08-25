package com.luisansal.bltx.ui.features.stepper

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

interface IStepperMVP {

    interface View : LifecycleOwner{
        fun setupViewPager(fragments : List<Fragment>)
        fun setupTab()
        fun onClickNext()
        fun onClickBack()
        fun moveToNext()
        fun returnBack()
        fun disableTouchTab()
        fun disableTouchViewPager()
        val notRequiredValidate : Boolean
        fun showValidationMessage(message : String)
        val currentFragment : Fragment?
        var isTheLast : Boolean
    }

    interface Presenter{
        fun init()
        fun validateNext()
        fun validateIfLast()
        fun bindViewPager()
    }

}