package com.example.muvi.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.muvi.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(MainActivity.getIntent(this))
    }
}
