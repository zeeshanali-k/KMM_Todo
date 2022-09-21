package com.devscion.kmmtodo

import com.devscion.kmmtodo.model.Todo

class TodoController {
    val todos = mutableListOf<Todo>()

    fun addTodo(todo: String) {
        todos.add(
            Todo(
                if (todos.size > 0)
                    todos.last().id + 1L
                else 1L,
                todo, getPlatformTodayDate().toString()
            )
        )
    }

    fun deleteTodo(todo: Todo) {
        todos.removeAt(todos.indexOf(todo))
    }

}