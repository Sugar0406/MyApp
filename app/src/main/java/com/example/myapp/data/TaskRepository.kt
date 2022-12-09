package com.example.myapp.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao :TaskDao) {
    val allTask: LiveData<List<Task>> = taskDao.readAll()

    fun addTask(task:Task){
        taskDao.insert(task)
    }
}