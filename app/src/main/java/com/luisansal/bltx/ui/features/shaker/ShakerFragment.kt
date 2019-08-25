package com.luisansal.bltx.ui.features.shaker

import android.os.Bundle
import android.view.View
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment

class ShakerFragment : BaseFragment(), ShakerFragmentMVP.View {
    override fun getLayout() = R.layout.fragment_shaker

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}