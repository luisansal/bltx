package com.luisansal.bltx.di.features

import com.luisansal.bltx.ui.features.stepper.StepperFragmentPresenter
import org.koin.dsl.module

val steppermodule = module {

    factory { params -> StepperFragmentPresenter(mView = params[0], mUseCase = get()) }

}