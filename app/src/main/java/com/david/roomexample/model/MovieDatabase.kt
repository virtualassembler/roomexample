package com.david.roomexample.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ApiMovie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDAO(): MovieDao
}