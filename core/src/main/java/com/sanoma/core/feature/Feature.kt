package com.sanoma.core.feature

import android.content.Context

interface Feature {

    fun increment()
    fun decrement()

    interface Provider {
        fun get(dependencies: Dependencies): Feature
    }

    interface Dependencies {
        fun getContext(): Context
    }

}