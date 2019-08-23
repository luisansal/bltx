package com.luisansal.bltx.di

import android.app.Activity
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

inline fun <reified T : Any> Activity.injectActivity(): Lazy<T> =
        inject(parameters = { parametersOf(this) })

inline fun <reified T : Any> Fragment.injectFragment(): Lazy<T> =
        inject(parameters = { parametersOf(this) })

inline fun <reified T : Any> KoinComponent.inject(vararg params: Any?): Lazy<T> =
        inject(parameters = { parametersOf(*params) })

inline fun <reified T : Any> KoinComponent.get(vararg params: Any?): T =
        get(parameters = { parametersOf(*params) })
