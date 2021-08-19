package com.nezspencer.compose1.data

import androidx.room.*
import com.nezspencer.compose1.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTask(task: Task)

    @Query("SELECT * FROM Task WHERE id = :taskId LIMIT 1")
    suspend fun getTask(taskId: Int): Task?

    @Query("SELECT * FROM Task")
    suspend fun getTasks(): List<Task>

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM Task")
    suspend fun deleteAllTasks()


}