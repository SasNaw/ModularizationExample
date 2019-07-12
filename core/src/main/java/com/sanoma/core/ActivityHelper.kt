@file:JvmName("ActivityHelper")

package com.sanoma.core

import android.content.Intent

private const val PACKAGE_NAME = "com.sanoma"

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