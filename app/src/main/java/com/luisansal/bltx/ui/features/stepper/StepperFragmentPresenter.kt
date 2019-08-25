package com.luisansal.bltx.ui.features.stepper

import androidx.lifecycle.Observer
import com.luisansal.bltx.ui.features.stepper.base.BaseStepperFragment

class StepperFragmentPresenter(private val mView: IStepperMVP.View, private val mUseCase: StepperUseCase) : IStepperMVP.Presenter {
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
        mUseCase.setupFragments().observe(mView, Observer { fragments ->
            mView.setupViewPager(fragments)
            mView.setupTab()
        })
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