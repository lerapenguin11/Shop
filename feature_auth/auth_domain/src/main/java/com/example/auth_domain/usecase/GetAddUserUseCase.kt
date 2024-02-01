package com.example.auth_domain.usecase

import com.example.auth_domain.entity.User
import com.example.auth_domain.repository.AuthRepository

class GetAddUserUseCase(private val repository: AuthRepository)
{
    suspend operator fun invoke(user : User) = repository.addUser(user = user)
}