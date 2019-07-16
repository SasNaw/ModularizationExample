@file:JvmName("ActivityHelper")

package com.sanoma.core

import android.content.Intent
import com.sanoma.core.feature.Feature

internal const val PACKAGE_NAME = "com.sanoma"

fun intentTo(addressableActivity: AddressableActivity): Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME,
        addressableActivity.className
    )
}

interface AddressableActivity {
    val className: String
}

object Activities {
    object Login : AddressableActivity {
        override val className = "$PACKAGE_NAME.login.LoginActivity"
        const val LOGIN_REQUEST_CODE = 42
        const val LOGIN_EXTRA_KEY = "extra_key"
    }
}

object Providers {
    val FEATURE_PROVIDER = Class.forName("$PACKAGE_NAME.feature_impl_test.FeatureImpl\$Provider")
        .kotlin.objectInstance as Feature.Provider
}