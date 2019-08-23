package com.luisansal.bltx.model

import android.app.Application
import com.luisansal.bltx.di.injectModules

open class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        injectModules(this@MyApplication)
    }
}