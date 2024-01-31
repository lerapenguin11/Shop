package com.example.auth_presentation.di

import com.example.auth_presentation.AuthFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(FragmentComponent::class)
object AuthModule {
    @ActivityScoped
    @Provides
    fun provideFragment(): AuthFragment {
        return AuthFragment()
    }
}