package com.example.training.database

import androidx.room.Database
import androidx.room.RoomDatabase

//TODO: Update naming
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}