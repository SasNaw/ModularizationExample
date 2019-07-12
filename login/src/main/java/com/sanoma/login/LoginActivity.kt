package com.sanoma.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sanoma.core.Activities
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonA.setOnClickListener { returnWithResult("button A pressed") }
        buttonB.setOnClickListener { returnWithResult("button B pressed") }
    }

    private fun returnWithResult(message: String) {
        val data = Intent()
        data.putExtra(Activities.Login.LOGIN_EXTRA_KEY, message)
        setResult(RESULT_OK, data)
        finish()
    }

}
