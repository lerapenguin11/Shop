package com.example.auth_data.repository

import com.example.auth_data.mapper.UserEntityMapper
import com.example.auth_data.room.UserDao
import com.example.auth_domain.entity.User
import com.example.auth_domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(private val dao: UserDao
) : AuthRepository
{
    private val mapper : UserEntityMapper = UserEntityMapper()
    override suspend fun addUser(user: User) =
        withContext(Dispatchers.IO){
            dao.insertUser(user = mapper.toUserEntity(user))
        }
}