package com.example.shop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.auth_presentation.AuthFragment
import com.example.basket_presentation.BasketFragment
import com.example.catalog_presentation.CatalogFragment
import com.example.home_presentation.HomeFragment
import com.example.navigation.NavigationUtils
import com.example.navigation.Navigator
import com.example.profile_presentation.ProfileFragment
import com.example.shop.databinding.ActivityMainBinding
import com.example.shop.viewmodel.MainViewModel
import com.example.stocks_presentation.StocksFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
public class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var navigator : Navigator
    @Inject
    lateinit var navigationUtils: NavigationUtils
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        navigation()
        binding.bottomNavigationView.selectedItemId = R.id.home

        supportFragmentManager.addFragmentOnAttachListener { fragmentManager, fragment ->
            if (fragment !is AuthFragment) {
                this.showBottomNavigationBar()
            }
            else {
                this.hideBottomNavigationBar()
            }
        }

        println(binding.bottomNavigationView.id)
    }

//TODO изменить названия метов
    private fun navigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            handleFragmentChange(it.itemId)
            true
        }
    }

    private fun handleFragmentChange(menuItemId: Int) {
        val code = viewModel.codeSher.getInt(PREF_CODE, CODE)

        if (code == 1) {
            when (menuItemId) {
                R.id.catalog -> navigateToNextFragment(CatalogFragment())
                R.id.home -> navigateToNextFragment(HomeFragment())
                R.id.basket -> navigateToNextFragment(BasketFragment())
                R.id.stocks -> navigateToNextFragment(StocksFragment())
                R.id.profile -> navigateToNextFragment(ProfileFragment())
            }
        }
        else {
            navigateToNextFragment(AuthFragment())
        }
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.main_layout)

        if (currentFragment is HomeFragment || currentFragment is AuthFragment
            || currentFragment is CatalogFragment || currentFragment is BasketFragment
            || currentFragment is StocksFragment || currentFragment is ProfileFragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun navigateToNextFragment(fragment : Fragment) {
        navigator = Navigator(fragmentManager = supportFragmentManager)
        navigator.navigateToFragmentAddBackStack(fragment = fragment)
    }

    private fun hideBottomNavigationBar() {
        navigationUtils.hideBottomNavigationBar(this, binding.bottomNavigationView)
    }

    private fun showBottomNavigationBar() {
        navigationUtils.showBottomNavigationBar(this, binding.bottomNavigationView)
    }

    companion object{
        private const val CODE = 0
        private const val PREF_CODE = "code"
    }
}