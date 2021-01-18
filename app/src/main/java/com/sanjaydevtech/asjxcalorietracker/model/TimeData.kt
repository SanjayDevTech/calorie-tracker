package com.sanjaydevtech.asjxcalorietracker.model

data class TimeData(
    val title: String,
    val foodList: List<Food> = listOf(),
)

data class Food(
    val name: String,
    val calorie: Int,
)
