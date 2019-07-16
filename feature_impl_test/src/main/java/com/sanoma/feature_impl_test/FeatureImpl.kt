package com.sanoma.feature_impl_test

import android.content.Context
import android.widget.Toast
import com.sanoma.core.feature.Feature
import com.sanoma.feature_impl_test.dagger.DaggerFeatureComponent
import timber.log.Timber
import javax.inject.Inject

class FeatureImpl @Inject constructor(private val context: Context) :
    Feature {

    private var value = 0

    override fun increment() {
        Timber.v("### increment()")
        val old = value
        value++
        makeToast(old, value)
    }

    override fun decrement() {
        Timber.v("### decrement()")
        val old = value
        value--
        makeToast(old, value)

    }

    private fun makeToast(old: Int, new: Int) {
        Toast.makeText(context, "old: $old, new: $new", Toast.LENGTH_SHORT).show()
    }

    companion object Provider : Feature.Provider {
        override fun get(dependencies: Feature.Dependencies): Feature {
            return DaggerFeatureComponent.builder().dependencies(dependencies).build().feature()
        }
    }

}
