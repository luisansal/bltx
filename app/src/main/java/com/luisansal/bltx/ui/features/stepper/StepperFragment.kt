package com.luisansal.bltx.ui.features.stepper

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment
import com.luisansal.bltx.di.injectFragment
import com.luisansal.bltx.ui.features.stepper.adapters.StepperAdapter
import kotlinx.android.synthetic.main.fragment_stepper.*

class StepperFragment : BaseFragment(), IStepperMVP.View {

    val mPresenter: StepperFragmentPresenter by injectFragment()

    override var isTheLast: Boolean = false

    override fun onClickBack() {
        btnBack.setOnClickListener {
            returnBack()
        }
    }

    override fun returnBack() {
        if (viewPager.currentItem > 0)
            viewPager.setCurrentItem(viewPager.currentItem - 1)
    }

    override fun disableTouchTab() {
        tabLayout.touchables.forEach { it.isClickable = false }
    }

    override fun disableTouchViewPager() {
        viewPager.setOnTouchListener { view, motionEvent ->
            true
        }
    }

    override var currentFragment: Fragment? = null

    override fun moveToNext() {
        viewPager.setCurrentItem(viewPager.currentItem + 1)
    }

    override fun setupTab() {
        tabLayout.setupWithViewPager(viewPager)
        disableTouchTab()
    }

    override fun setupViewPager(fragments: List<Fragment>) {
        val adapter = StepperAdapter(fragmentManager!!)
        adapter.update(fragments)
        viewPager.adapter = adapter
        disableTouchViewPager()
    }

    override fun onClickNext() {
        btnNext.setOnClickListener {
            val adapter = (viewPager.adapter as StepperAdapter)
            currentFragment = adapter.getItem(viewPager.currentItem)
            if (viewPager.currentItem + 1 == adapter.count)
                isTheLast = true
            mPresenter.validateNext()
        }
    }

    override val notRequiredValidate: Boolean = false

    override fun showValidationMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun getLayout() = R.layout.fragment_stepper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.init()
    }
}