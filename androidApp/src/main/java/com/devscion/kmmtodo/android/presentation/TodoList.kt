package com.devscion.kmmtodo.android.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun TodoList(
    todosViewModel: TodosViewModel
) {
    val todos = todosViewModel.todosState.collectAsState()

    LazyColumn(Modifier.fillMaxSize()) {
        items(todos.value) {
            TodoListItem(it, todosViewModel)
        }
    }

}