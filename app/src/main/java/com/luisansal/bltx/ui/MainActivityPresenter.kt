package com.luisansal.bltx.ui

import androidx.fragment.app.Fragment
import com.luisansal.bltx.ui.mvp.IMainActivityMVP
import java.util.ArrayList

class MainActivityPresenter(var view: IMainActivityMVP.View): IMainActivityMVP.Presenter{

    var interactor : IMainActivityMVP.Interactor = MainActivityInteractor(this)

    override fun init() {
        view.setupTabListener()
        boundFragments()
    }

    override fun setupViewPager(fragments: ArrayList<Fragment> ) {
        view.setupViewPager(fragments)
    }

    override fun setupActionBar(fragments: ArrayList<Fragment> ) {
        view.setupActionBar(fragments)
    }

    override fun boundFragments() {
        interactor.boundFragments()
    }


}