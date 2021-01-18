package com.sanjaydevtech.asjxcalorietracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class TimeData(
    val title: String,
    val foodList: List<Food> = listOf(),
)

@Entity
data class Food(
    @PrimaryKey
    val id: String = "",
    val name: String,
    val calorie: Int,
)

@Entity(primaryKeys = ["day", "month", "year"])
data class Daily(
    val day: Int,
    val month: Int,
    val year: Int,
    @ColumnInfo(name = "break_fast")
    val breakFast: Food,
    val lunch: Food,
    val dinner: Food,
)
