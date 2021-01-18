package com.sanjaydevtech.asjxcalorietracker.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sanjaydevtech.asjxcalorietracker.model.Daily
import com.sanjaydevtech.asjxcalorietracker.model.Food
import com.sanjaydevtech.asjxcalorietracker.model.TimeData

@Dao
interface DailyDao{
    @Insert
    suspend fun insert(daily: Daily)

    @Update
    suspend fun update(daily: Daily)

    @Query("SELECT * FROM daily")
    fun getAllDailyData(): LiveData<List<Daily>>

    @Query("SELECT * FROM daily WHERE day=:day AND month=:month AND year=:year")
    suspend fun getDailyData(day: Int, month: Int, year: Int): Daily?

    @Query("DELETE FROM daily")
    suspend fun clear()
}

@Dao
interface FoodDao {
    @Query("SELECT * FROM food")
    fun getAllFoods(): LiveData<List<Food>>

    @Query("SELECT * FROM food WHERE id=:id")
    suspend fun getFood(id: String): Food?

    @Insert
    suspend fun insertAll(vararg foods: Food)
}