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
    val todoValue = MutableStateFlow("")

    private val _todosState: MutableStateFlow<List<Todo>> = MutableStateFlow(listOf())
    val todosState: StateFlow<List<Todo>> = _todosState

    init {
        getTodos()
    }

    private fun getTodos() {
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

    fun addTodo() {
        if(todoValue.value.isEmpty()) return
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.insertTodo(todoValue.value).collectLatest { dr ->
                if (dr is DataResponse.Success) {
                    getTodos()
                    todoValue.value = ""
                }
            }
        }
    }

    fun toggleDone(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.toggleTodo(todo).collectLatest {
                if (it is DataResponse.Success) {
                    getTodos()
                }
            }
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.deleteTodo(todo).collectLatest {
                if (it is DataResponse.Success) {
                    getTodos()
                }
            }
        }
    }

}