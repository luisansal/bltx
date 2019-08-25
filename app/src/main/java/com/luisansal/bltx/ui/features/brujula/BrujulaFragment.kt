package com.luisansal.bltx.ui.features.brujula

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_brujula.*

class BrujulaFragment : BaseFragment(), BrujulaFragmentMVP.View {
    override fun getLayout() = R.layout.fragment_brujula


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etDegrees.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0?.isEmpty()!!)
                    return
                brujulaComponent.updateDirection(p0.toString().toFloat())
            }
        })
    }
}