package com.sanoma

import android.app.Application
import com.sanoma.dagger.BaseComponent
import com.sanoma.dagger.DaggerBaseComponent

class MyApplication : Application() {

    private val baseComponent: BaseComponent by lazy {
        DaggerBaseComponent.builder()
            .context(this)
            .build()
    }

    fun feature() = baseComponent.feature()
}