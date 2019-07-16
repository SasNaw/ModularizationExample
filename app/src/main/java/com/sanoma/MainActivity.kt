package com.sanoma

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sanoma.core.Activities
import com.sanoma.core.intentTo
import com.sanoma.dagger.BaseComponent
import com.sanoma.dagger.DaggerBaseComponent
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val baseComponent: BaseComponent by lazy {
        DaggerBaseComponent.builder()
            .context(this)
            .build()
    }

    private val feature = baseComponent.feature()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener {
            startActivityForResult(
                intentTo(Activities.Login),
                Activities.Login.LOGIN_REQUEST_CODE
            )
        }

        increment.setOnClickListener {
            feature?.increment() ?: Timber.e("### feature == null!")
        }

        decrement.setOnClickListener {
            feature?.decrement() ?: Timber.e("### feature == null!")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Activities.Login.LOGIN_REQUEST_CODE) {
            Toast.makeText(
                this,
                data?.getStringExtra(Activities.Login.LOGIN_EXTRA_KEY),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}