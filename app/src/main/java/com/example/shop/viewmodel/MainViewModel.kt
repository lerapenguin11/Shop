package com.example.shop.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application)
    : AndroidViewModel(application)
{
    val codeSher : SharedPreferences = application.getSharedPreferences("pref_pofile", Context.MODE_PRIVATE)
}