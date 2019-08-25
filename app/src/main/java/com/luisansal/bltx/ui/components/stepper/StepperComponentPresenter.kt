package com.luisansal.bltx.ui.components.stepper

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.luisansal.bltx.ui.components.stepper.base.BaseStepperFragment

class StepperComponentPresenter(private val mView: IStepperMVP.View, private val fragments: List<Fragment>) : IStepperMVP.Presenter {
    override fun validateIfLast() {
        if (mView.isTheLast) {
            mView.showValidationMessage("All right all steps finished")
        }
    }

    override fun init() {
        bindViewPager()
        mView.onClickNext()
        mView.onClickBack()
    }

    override fun bindViewPager() {
        mView.setupViewPager(fragments)
        mView.setupTab()
    }

    override fun validateNext() {
        if (mView.currentFragment !is BaseStepperFragment)
            return

        val currentFragment = (mView.currentFragment as BaseStepperFragment)
        if (!currentFragment.requireValidation) {
            mView.moveToNext()
        } else {
            if (!currentFragment.isValidated){
                mView.showValidationMessage("Validation required")
            } else {
                mView.moveToNext()
                validateIfLast()
            }
        }

    }

}