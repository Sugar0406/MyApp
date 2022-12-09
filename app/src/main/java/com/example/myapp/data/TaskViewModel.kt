package com.example.myapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val readAll: LiveData<List<Task>>
    private val repository: TaskRepository

    init{
        val taskDao = TaskDataBase.getDB(application).taskdao
        repository = TaskRepository(taskDao)
        readAll = repository.allTask
    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }
}