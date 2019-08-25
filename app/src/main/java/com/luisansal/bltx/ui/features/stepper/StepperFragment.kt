package com.luisansal.bltx.ui.features.stepper

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment
import com.luisansal.bltx.di.injectFragment
import kotlinx.android.synthetic.main.fragment_stepper.*

class StepperFragment : BaseFragment(), IStepperMVP.View {

    override fun setupStepper(fragments: List<Fragment>) {
        stepperComponent.setup(fragments, fragmentManager!!)
    }

    val mPresenter: StepperFragmentPresenter by injectFragment()

    override fun getLayout() = R.layout.fragment_stepper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.init()
    }

}