package com.luisansal.bltx.ui.features.brujula

import android.os.Bundle
import android.view.View
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment

class BrujulaFragment : BaseFragment(), BrujulaFragmentMVP.View {
    override fun getLayout() = R.layout.fragment_brujula

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}