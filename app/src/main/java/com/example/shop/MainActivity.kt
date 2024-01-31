package com.example.shop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.auth_presentation.AuthFragment
import com.example.home_presentation.HomeFragment
import com.example.navigation.Navigator
import com.example.shop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.navigation.NavigationBarView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var navigator : Navigator

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateToNextFragment()
    }

    private fun navigateToNextFragment() {
        navigator = Navigator(fragmentManager = supportFragmentManager)
        navigator.navigateToFragmentAddBackStack(AuthFragment())
    }
}