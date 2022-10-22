package com.devscion.kmmtodo

import com.devscion.kmmtodo.model.Todo
import kotlinx.datetime.*

class TodoHelper {
    val todos = mutableListOf<Todo>()

    fun addTodo(todo: String) {
        val now: Instant = Clock.System.now()
        val today = now.toLocalDateTime(TimeZone.currentSystemDefault()).date.toString()
        todos.add(
            Todo(
                if (todos.size > 0)
                    todos.last().id + 1L
                else 1L,
                todo, today
            )
        )
    }

    fun getTodo(todo: String) : Todo {
        val now: Instant = Clock.System.now()
        val today = now.toLocalDateTime(TimeZone.currentSystemDefault()).date.toString()

        return Todo(
            if (todos.size > 0)
                todos.last().id + 1L
            else 1L,
            todo, today
        )

    }

    fun deleteTodo(todo: Todo) {
        todos.removeAt(todos.indexOf(todo))
    }

}