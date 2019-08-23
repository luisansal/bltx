package com.luisansal.bltx.ui.mvp

import java.util.ArrayList

import androidx.fragment.app.Fragment

interface IMainActivityMVP {
    interface View {
        fun setupTabListener()
        fun setupViewPager(fragments: ArrayList<Fragment>)
        fun setupActionBar(fragments: ArrayList<Fragment>)
    }

    interface Presenter {
        fun init()
        fun setupViewPager(fragments: ArrayList<Fragment>)
        fun setupActionBar(fragments: ArrayList<Fragment>)
        fun boundFragments()
    }

    interface Interactor {
        fun boundFragments()
    }
}
