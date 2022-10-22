package com.devscion.kmmtodo.data.db

import com.devscion.kmmtodo.TodoHelper
import com.devscion.kmmtodo.model.Todo
import com.devscoion.kmmtodo.database.TodosDB

class TodosDBController(
    todosDB: TodosDB,
) {
    private val todosQueries = todosDB.todoQueries
    private val todosController = TodoHelper()

    fun addTodo(todoStr: String) {
        val todo = todosController.getTodo(todoStr)
        todosQueries.insertTodo(todo.todo, todo.date, if (todo.isDone) 1L else 0L)
    }

    fun getTodos(): List<Todo> {
        return todosQueries.getAllTodos().executeAsList().toTodosList()
    }


    private fun List<database.Todo>.toTodosList(): List<Todo> = map {
        Todo(it.id, it.todo, it.date, it.isDone == 1L)
    }
}