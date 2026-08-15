package com.atif.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.atif.todoapp.data.room_database.TaskDatabase
import com.atif.todoapp.data.room_database.TaskItem
import com.atif.todoapp.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
private val dao = TaskDatabase.getDatabase(application).taskDao()

private  val repository = TaskRepository(dao)

    val  allTasks: StateFlow<List<TaskItem>> =
        repository.getAllTasks()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),
            emptyList()
            )
    fun addTask(task: TaskItem){
        viewModelScope.launch {
            repository.insert(task)
        }
    }
    fun updateTask(task: TaskItem){
        viewModelScope.launch {
            repository.update(task)
        }
    }
    fun deleteTask(task: TaskItem){
        viewModelScope.launch {
            repository.delete(task)
        }
    }

}