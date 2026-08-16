package com.atif.todoapp.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atif.todoapp.data.room_database.TaskItem
import com.atif.todoapp.viewmodel.TaskViewModel


@Composable
fun ToDoListScreen(viewModel: TaskViewModel) {
    val tasks by viewModel.allTasks.collectAsState()
    var taskToEdit by remember { mutableStateOf<TaskItem?>(null) }

    var showEditorDialog by remember { mutableStateOf(false) }
    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    taskToEdit = null
                    showEditorDialog = true
                },
                shape = RoundedCornerShape(16.dp),
                containerColor = Color(0xFF2D3135),
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task"
                )
                Text("New Task", modifier = Modifier.padding(start = 8.dp), fontWeight = FontWeight.SemiBold)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "My Tasks",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 34.sp,
                color = Color(0xFF1A1C1E),
                letterSpacing = (-0.5).sp
            )
            val remainingTasks = tasks.count { !it.isDone }
            Text(
                if (remainingTasks == 0 && tasks.isNotEmpty()) "All done for today! 🎉" 
                else "$remainingTasks Remaining Today",
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(32.dp))
            
            if (tasks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("No Tasks Yet", color = Color.Gray, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                        Text("Tap + to add your first task", color = Color.LightGray, fontSize = 14.sp)
                    }
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
                    items(
                        items = tasks,
                        key = { it.id }
                    ) { task ->
                        ToDoItem(
                            item = task,
                            onEditClick = {
                                taskToEdit = task
                                showEditorDialog = true
                            },
                            onDeleteClick = { viewModel.deleteTask(task) },
                            onCheckChange = { checked -> viewModel.updateTask(task.copy(isDone = checked)) }
                        )
                    }
                }
            }
        }
    }
    if (showEditorDialog) {
        TaskEditorDialog(
            task = taskToEdit,
            onSave = { newName ->
                if (taskToEdit == null) {
                    viewModel.addTask(TaskItem(taskName = newName, isDone = false))
                } else {
                    taskToEdit?.let { viewModel.updateTask(it.copy(taskName = newName)) }
                }

                showEditorDialog = false
                taskToEdit = null
            },
            onCancel = {
                showEditorDialog = false
                taskToEdit = null
            }
        )
    }
}
