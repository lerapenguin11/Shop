package com.example.auth_presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth_domain.entity.User
import com.example.auth_domain.usecase.GetAddUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val getAddUserUseCase: GetAddUserUseCase,
    application: Application
) : AndroidViewModel(application)
{
    val codeSher : SharedPreferences = application.getSharedPreferences("pref_pofile", Context.MODE_PRIVATE)

    fun saveCode(code : Int) {
        codeSher.edit().apply {
            putInt("code", code)
            apply()
        }
    }

    fun insertUser(user : User) = viewModelScope.launch{
        getAddUserUseCase.invoke(user = user)
    }

    fun validateInput(
        inputName : String?, inputSurname : String?,
        inputNumberPhone : String?) : Boolean{
        var result = true
        val name = parseName(inputName)
        val surname = parseSurname(inputSurname)
        val patronymic = parseNumberPhone(inputNumberPhone)
        if (name.isBlank()){
            result =  false
        }
        if (surname.isBlank()){
            result = false
        }
        if (patronymic.isBlank()){
            result = false
        }
        return result
    }

    private fun parseName(inputName : String?) : String{
        return inputName?.trim() ?: ""
    }

    private fun parseSurname(inputSurname : String?) : String{
        return inputSurname?.trim() ?: ""
    }

    private fun parseNumberPhone(inputNumberPhone : String?) : String{
        return inputNumberPhone?.trim() ?: ""
    }
}