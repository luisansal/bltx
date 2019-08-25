package com.luisansal.bltx.ui.components.brujula

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView

class CompassView : ImageView {
    private var mDirection: Float = 0F
    private var compass: Drawable? = null

    constructor(context: Context) : super(context) {
        mDirection = 0.0f
        compass = null
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mDirection = 0.0f
        compass = null
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        mDirection = 0.0f
        compass = null
    }

    override fun onDraw(canvas: Canvas) {
        if (compass == null) {
            compass = getDrawable()
            compass!!.setBounds(0, 0, getWidth(), getHeight())
        }

        canvas.save()
        canvas.rotate(mDirection, (getWidth() / 2).toFloat(), (getHeight() / 2).toFloat())
        compass!!.draw(canvas)
        canvas.restore()
    }

    fun updateDirection(direction: Float) {
        mDirection = direction
        invalidate()
    }

}