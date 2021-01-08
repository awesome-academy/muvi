package com.example.muvi.ui.main

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.muvi.R
import com.example.muvi.base.BottomNavigationListener
import com.example.muvi.databinding.ActivityMainBinding
import com.example.muvi.utils.hide
import com.example.muvi.utils.show

class MainActivity : AppCompatActivity(), BottomNavigationListener {

    private val navController by lazy { findNavController(R.id.navHostFragment) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    override fun onBackPressed() {
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        navController.popBackStack()
    }

    private fun setUpView() {
        binding.navView.setupWithNavController(navController)
    }

    override fun showNav() {
        binding.navView.show()
    }

    override fun hideNav() {
        binding.navView.hide()
    }
}
