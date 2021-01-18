package com.sanjaydevtech.asjxcalorietracker

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: Repository) : ViewModel() {
    val foodDao = repository.foodDao()
    val dailyDao = repository.dailyDao()

    init {
        Log.e("MainViewModel", "init:  ViewModel called", )
    }
}