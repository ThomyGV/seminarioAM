package com.example.dune

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity

class SplashScreenActivity : ComponentActivity() {

    private val demora : Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val r = Runnable {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            finish()
        }
        Handler(Looper.getMainLooper()).postDelayed(r, demora)

    }
}