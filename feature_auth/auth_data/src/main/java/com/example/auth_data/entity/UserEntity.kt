package com.example.auth_data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val name : String,
    val surname : String,
    val numberPhone : String
)