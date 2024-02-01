package com.example.navigation

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationUtils {
    fun hideBottomNavigationBar(activity: AppCompatActivity, bottomNavigationView: BottomNavigationView) {
        activity.supportActionBar?.hide()
        bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNavigationBar(activity: AppCompatActivity, view: View?) {
        activity.supportActionBar?.show()
        val bottomNavigationView : BottomNavigationView? = view?.findViewById(R.id.bottomNavigationView)
        bottomNavigationView?.visibility = View.VISIBLE
    }
}