package com.devscion.kmmtodo.android.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devscion.kmmtodo.android.R

@Composable
fun AddTodo(todosViewModel: TodosViewModel) {
    val todo = todosViewModel.todoValue.collectAsState()
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        OutlinedTextField(
            value = todo.value, onValueChange = {
                todosViewModel.todoValue.value = it
            }, modifier = Modifier
                .padding(horizontal = 5.dp)
                .weight(2f),
            placeholder = {
                Text(text = "Enter Task")
            },
            shape = CircleShape
        )
        IconButton(onClick = {
            todosViewModel.addTodo()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_add_24),
                contentDescription = "add",
                modifier = Modifier
                    .padding(10.dp)
                    .size(25.dp)
            )
        }
    }
}