package com.luisansal.bltx.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {
    override fun getLayout() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickBtnBrujula()
        onClickBtnShaker()
        onClickBtnStepper()
    }

    fun onClickBtnStepper(){
        btnStepper.setOnClickListener {
            findNavController().navigate(R.id.stepperFragment)
        }
    }

    fun onClickBtnShaker(){
        btnShaker.setOnClickListener {
            findNavController().navigate(R.id.shakerFragment)
        }
    }

    fun onClickBtnBrujula(){
        btnBrujula.setOnClickListener {
            findNavController().navigate(R.id.brujulaFragment)
        }
    }
}