package com.devscion.kmmtodo.android.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devscion.kmmtodo.model.Todo

@Composable
fun TodoListItem(todo: Todo){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Text(text = todo.todo)
    }
}