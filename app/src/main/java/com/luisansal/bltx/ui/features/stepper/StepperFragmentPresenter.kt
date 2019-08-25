package com.luisansal.bltx.ui.features.stepper

import androidx.lifecycle.Observer

class StepperFragmentPresenter(private val mView: IStepperMVP.View, private val mUseCase: StepperUseCase) : IStepperMVP.Presenter {

    override fun init() {
        mUseCase.setupFragments().observe(mView, Observer { fragments ->
            mView.setupStepper(fragments)
        })

    }

}