package com.atif.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class TaskViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    fun <T : ViewModel> get(key: String, modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)
        ) {
            return TaskViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}