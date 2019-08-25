package com.luisansal.bltx.ui.components.stepper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

interface IStepperMVP {

    interface View {
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
        fun setup(fragments : List<Fragment>,fm: FragmentManager)
    }

    interface Presenter{
        fun init()
        fun validateNext()
        fun validateIfLast()
        fun bindViewPager()
    }

}