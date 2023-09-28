package com.example.testpokeon.views.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.testpokeon.R
import com.example.testpokeon.constants.Constants

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        initUI()
    }

    private fun initUI() {

        object : CountDownTimer(Constants.SPLASH_TIME_OUT.toLong(), Constants.SPLASH_TIME_OUT.toLong()) {
            override fun onTick(millisUntilFinished: Long) {
                // No se necesita hacer nada en este método
            }

            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}