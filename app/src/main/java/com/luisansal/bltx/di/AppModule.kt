package com.luisansal.bltx.di

import android.app.Application
import com.luisansal.bltx.di.features.brujulamodule
import com.luisansal.bltx.di.features.shakermodule
import com.luisansal.bltx.di.features.steppermodule
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun injectModules(app: Application) {

    startKoin {
        // use AndroidLogger as Koin Logger - default Level.INFO
        androidLogger()

        // use the Android context given there
        androidContext(app)

        // load properties from assets/koin.properties file
        androidFileProperties()

        // module list
        modules(appModules)
    }
}


private val appModules =
    listOf(
        steppermodule,
        brujulamodule,
        shakermodule,
        usecasemodule
    )





