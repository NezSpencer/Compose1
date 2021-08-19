package com.nezspencer.compose1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nezspencer.compose1.Task


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        fun create(applicationContext: Context): TaskDatabase =
            Room.databaseBuilder(applicationContext, TaskDatabase::class.java, "task_db").build()
    }
}