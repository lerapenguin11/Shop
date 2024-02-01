package com.example.navigation

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    fun provideNavigator(fragmentManager: FragmentManager): Navigator {
        return Navigator(fragmentManager = fragmentManager)
    }

    @Provides
    fun provideAppCompatActivity(): AppCompatActivity {
        return AppCompatActivity()
    }

    @Provides
    fun provideNavigationUtils(): NavigationUtils {
        return NavigationUtils()
    }
}