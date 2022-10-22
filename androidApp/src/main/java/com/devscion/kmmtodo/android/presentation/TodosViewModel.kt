package com.devscion.kmmtodo.android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devscion.kmmtodo.TodoHelper
import com.devscion.kmmtodo.android.data.model.DataResponse
import com.devscion.kmmtodo.android.domain.repo.TodoRepository
import com.devscion.kmmtodo.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
) : ViewModel() {

    private val todoController: TodoHelper = TodoHelper()

    private val _todosState: MutableStateFlow<List<Todo>> = MutableStateFlow(listOf())
    val todosState: StateFlow<List<Todo>> = _todosState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.getAllTodos().collectLatest { dr ->
                if (dr is DataResponse.Success) {
                    _todosState.update {
                        dr.data ?: listOf()
                    }
                }
            }
        }
    }

    fun addTodo(todo: String) {
        todoController.addTodo(todo)
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.insertTodo(todoController.todos.last()).collectLatest { dr ->
                if (dr is DataResponse.Success) {
                    _todosState.update {
                        it.toMutableList().apply {
                            add(todoController.todos.last())
                        }.toList()
                    }
                }
            }
        }
    }

}