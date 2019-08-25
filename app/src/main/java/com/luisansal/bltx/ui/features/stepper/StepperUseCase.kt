package com.luisansal.bltx.ui.features.stepper

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.luisansal.bltx.ui.features.stepper.fragments.Step1Fragment
import com.luisansal.bltx.ui.features.stepper.fragments.Step2Fragment
import com.luisansal.bltx.ui.features.stepper.fragments.Step3Fragment

class StepperUseCase {

    fun setupFragments() : LiveData<List<Fragment>>{
        val liveData = MutableLiveData<List<Fragment>>()

        val fragments = mutableListOf<Fragment>(
            Step1Fragment(),
            Step2Fragment(),
            Step3Fragment()
        )

        liveData.value = fragments
        return liveData
    }

}