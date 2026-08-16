package com.atif.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.atif.todoapp.ui.screens.ToDoListScreen
import com.atif.todoapp.ui.theme.ToDoAppTheme
import com.atif.todoapp.viewmodel.TaskViewModel
import com.atif.todoapp.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    private val viewModel: TaskViewModel by viewModels{
        TaskViewModelFactory(application)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {

                ToDoListScreen(viewModel)

            }
        }
    }
}

