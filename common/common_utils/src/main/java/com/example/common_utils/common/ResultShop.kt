package com.example.common_utils.common

sealed class ResultShop<out R> {

    data class Success<out T>(val data: T) : ResultShop<T>()
    data class Error(val exception: Exception) : ResultShop<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}