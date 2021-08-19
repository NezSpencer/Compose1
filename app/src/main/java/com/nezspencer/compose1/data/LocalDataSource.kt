package com.nezspencer.compose1.data

import com.nezspencer.compose1.Task

interface LocalDataSource {
    suspend fun saveTask(task: Task)
    suspend fun getTasks(): List<Task>
    suspend fun getTask(taskId: Int): Task?
    suspend fun deleteTask(task: Task)
    suspend fun deleteAllTasks()
}


class LocalDataSourceImpl(private val taskDao: TaskDao): LocalDataSource {
    override suspend fun saveTask(task: Task) = taskDao.saveTask(task)

    override suspend fun getTasks(): List<Task> = taskDao.getTasks()

    override suspend fun getTask(taskId: Int): Task? = taskDao.getTask(taskId)

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)

    override suspend fun deleteAllTasks() = taskDao.deleteAllTasks()
}