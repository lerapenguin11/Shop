package com.example.auth_domain.repository

import com.example.auth_domain.entity.User

interface AuthRepository
{
    suspend fun addUser(user : User)
}