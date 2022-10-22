package com.devscion.kmmtodo.android.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun TodoList(
    viewModel: TodosViewModel
){
    val todos = viewModel.todosState.collectAsState()
    LaunchedEffect(key1 = true){
        viewModel.addTodo("Testing")
    }

    Column(Modifier.fillMaxSize()) {
        for (todo in todos.value){
            TodoListItem(todo)
        }
    }

}