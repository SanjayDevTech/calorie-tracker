package com.sanjaydevtech.asjxcalorietracker.model

data class TimeData(
    val title: String,
    val foodList: List<Food> = listOf(
        Food("Dosai", 54)
    ),
)

data class Food(
    val name: String,
    val calorie: Int,
)
