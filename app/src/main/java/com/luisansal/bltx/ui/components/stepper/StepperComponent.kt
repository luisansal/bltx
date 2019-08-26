package com.luisansal.bltx.ui.components.stepper

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.luisansal.bltx.R
import com.luisansal.bltx.ui.components.stepper.adapters.StepperAdapter
import kotlinx.android.synthetic.main.stepper_component.view.*

class StepperComponent(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : ConstraintLayout(context, attrs, defStyleAttr),
    IStepperMVP.View {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    private lateinit var mFragmentManager : FragmentManager
    private lateinit var mPresenter : StepperComponentPresenter

    override fun setup(fragments: List<Fragment>, fm: FragmentManager) {
        mFragmentManager = fm
        mPresenter = StepperComponentPresenter(this, fragments)
        mPresenter.init()
    }

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.stepper_component, this, true)
    }

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
        val adapter = StepperAdapter(mFragmentManager)
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

}