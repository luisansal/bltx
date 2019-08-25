package com.luisansal.bltx.ui.components.brujula

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.luisansal.bltx.R
import kotlinx.android.synthetic.main.brujula_component.view.*


class BrujulaComponent(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : LinearLayout(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.brujula_component, this, true)
    }

    fun updateDirection(direction : Float){
        compass_pointer.updateDirection(direction)
    }

}