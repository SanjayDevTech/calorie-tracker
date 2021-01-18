package com.sanjaydevtech.asjxcalorietracker

import com.sanjaydevtech.asjxcalorietracker.database.MainDatabase

class Repository(private val database: MainDatabase) {
    fun dailyDao() = database.dailyDao()
    fun foodDao() = database.foodDao()
}