package com.example.auth_presentation.viewmodel

import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel()
{
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