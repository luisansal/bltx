package com.luisansal.bltx.ui.features.shaker

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.luisansal.bltx.R
import com.luisansal.bltx.common.BaseFragment
import com.luisansal.bltx.ui.features.shaker.listeners.ShakeDetector
import kotlinx.android.synthetic.main.fragment_shaker.*

class ShakerFragment : BaseFragment(), ShakerFragmentMVP.View {
    override fun getLayout() = R.layout.fragment_shaker

    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometer: Sensor
    private lateinit var mShakeDetector: ShakeDetector


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mShakeDetector = ShakeDetector()
        mShakeDetector!!.setOnShakeListener(object : ShakeDetector.OnShakeListener {

            override fun onShake(count: Int) {
                tvShake.setText("Shake Action is just detected!!")
                Toast.makeText(context, "Shaked!!!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onResume() {
        super.onResume()

        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()

        mSensorManager.unregisterListener(mShakeDetector)
    }

}