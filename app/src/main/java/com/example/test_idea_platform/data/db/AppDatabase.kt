package com.example.test_idea_platform.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.test_idea_platform.presentation.di.Application

@Database(entities = [DeviceEntity::class], version = 11)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao

    companion object {
        private const val DATABASE_NAME = "data"

        val instance: AppDatabase by lazy {
            Room.databaseBuilder(
                Application.appContext,
                AppDatabase::class.java,
                DATABASE_NAME
            )
                .createFromAsset("data.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}