package com.example.shop.di

import android.app.Application
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.auth_data.room.UserDao
import com.example.shop.R
import com.example.shop.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideUserDAO(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }
}