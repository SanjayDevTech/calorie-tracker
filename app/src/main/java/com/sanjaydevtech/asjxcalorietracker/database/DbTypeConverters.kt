package com.sanjaydevtech.asjxcalorietracker.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sanjaydevtech.asjxcalorietracker.model.Food

class DbTypeConverters {
    val gson by lazy {
        Gson()
    }

    @TypeConverter
    fun fromFood(food: Food): String = gson.toJson(food)

    @TypeConverter
    fun toFood(strFood: String): Food = gson.fromJson(strFood, Food::class.java)
}