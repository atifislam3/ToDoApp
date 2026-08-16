package com.atif.todoapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atif.todoapp.data.room_database.TaskItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditorDialog(
    task: TaskItem?,
    onSave: (String)-> Unit,
    onCancel: ()-> Unit
) {
    var taskName by remember { mutableStateOf(task?.taskName ?:"") }

    ModalBottomSheet(
        onDismissRequest = onCancel
        , containerColor = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp).
            navigationBarsPadding()
        ) {
            Text(text = if (task==null)"Create New Task" else "Update Task",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold

            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = taskName,
                onValueChange = {taskName=it},
                modifier = Modifier.fillMaxWidth(),
                placeholder = {Text("What's needs to be done?", color = Color.Gray)}
                , colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.DarkGray,
                    unfocusedBorderColor = Color.Gray,
                ),
                shape = RoundedCornerShape(12.dp)

            )
            Spacer(modifier = Modifier.height(26.dp))
            Button(
                onClick = {onSave(taskName.trim())},
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(Color.DarkGray)

                , enabled = taskName.isNotBlank()
            ){
            Text("Save Task",
                fontSize = 16.sp,
            )
            }



        }
    }
}