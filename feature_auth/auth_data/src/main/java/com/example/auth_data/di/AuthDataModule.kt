package com.example.auth_data.di

import com.example.auth_data.repository.AuthRepositoryImpl
import com.example.auth_data.room.UserDao
import com.example.auth_domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AuthDataModule
{
    @Provides
    fun provideAuthRepository(dao : UserDao) : AuthRepository{
        return AuthRepositoryImpl(dao = dao)
    }
}