package com.sanjaydevtech.asjxcalorietracker

import android.app.Application
import com.sanjaydevtech.asjxcalorietracker.database.MainDatabase

class CalorieTracker : Application() {
    private val database: MainDatabase by lazy {
        MainDatabase.getDatabase(this.applicationContext)
    }

    val repository: Repository by lazy {
        Repository(database)
    }
}