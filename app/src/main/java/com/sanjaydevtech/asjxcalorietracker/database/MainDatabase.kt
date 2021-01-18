package com.sanjaydevtech.asjxcalorietracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sanjaydevtech.asjxcalorietracker.model.Daily
import com.sanjaydevtech.asjxcalorietracker.model.Food
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(entities = [Food::class, Daily::class], version = 1, exportSchema = false)
@TypeConverters(DbTypeConverters::class)
abstract class MainDatabase : RoomDatabase() {
    abstract fun dailyDao(): DailyDao
    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                "main_database.db"
            )
                .fallbackToDestructiveMigration()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        MainScope().launch {
                            getDatabase(context).foodDao().insertAll(
                                Food("1", "Dosai", 133),
                                Food("2", "Rice", 130),
                                Food("3", "Idli", 39),
                                Food("4", "Chapati", 104),
                            )
                        }
                    }
                })
                .build()
            INSTANCE = instance
            instance
        }
    }
}