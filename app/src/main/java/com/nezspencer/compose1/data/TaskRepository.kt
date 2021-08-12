package com.nezspencer.compose1.data

import com.nezspencer.compose1.Task

interface TaskRepository {
    suspend fun saveTask(task: Task)
    suspend fun getTask(taskInt: Int): Task?
    suspend fun getTasks(): List<Task>
    suspend fun deleteTask(task: Task)
    suspend fun deleteAllTasks()
}

class TaskRepositoryImpl(private val localDataSourceImpl: LocalDataSourceImpl): TaskRepository {
    override suspend fun saveTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(taskInt: Int): Task? {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllTasks() {
        TODO("Not yet implemented")
    }
}