package com.example.auth_data.mapper

import com.example.auth_data.entity.UserEntity
import com.example.auth_domain.entity.User

class UserEntityMapper
{
    fun toUserEntity(user : User) : UserEntity{
        return UserEntity(
            id = 1,
            name = user.name,
            surname = user.surname,
            numberPhone = user.numberPhone
        )
    }
}