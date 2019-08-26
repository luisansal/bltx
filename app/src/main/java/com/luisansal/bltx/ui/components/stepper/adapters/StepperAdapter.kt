package com.luisansal.bltx.ui.components.stepper.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class StepperAdapter : FragmentPagerAdapter {

    constructor(fm: FragmentManager) : this(fm, POSITION_NONE)
    constructor(fm: FragmentManager, behavior: Int) : super(fm, behavior)

    private var mFragments: List<Fragment> = emptyList()

    fun update(fragments: List<Fragment>) {
        mFragments = fragments
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return mFragments.get(position)
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Step " + (position + 1).toString()
    }
}