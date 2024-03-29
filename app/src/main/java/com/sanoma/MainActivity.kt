package com.sanoma

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sanoma.core.Activities
import com.sanoma.core.intentTo
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

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
            (application as MyApplication).feature()?.increment()
                ?: Timber.e("### feature == null!")
        }

        decrement.setOnClickListener {
            (application as MyApplication).feature()?.decrement()
                ?: Timber.e("### feature == null!")
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