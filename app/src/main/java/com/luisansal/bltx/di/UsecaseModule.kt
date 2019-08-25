package com.luisansal.bltx.di

import com.luisansal.bltx.ui.features.stepper.StepperUseCase
import org.koin.dsl.module

val usecasemodule = module {

    factory { StepperUseCase() }

}