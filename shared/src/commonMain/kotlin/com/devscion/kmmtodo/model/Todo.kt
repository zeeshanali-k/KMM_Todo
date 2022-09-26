package com.devscion.kmmtodo.model

data class Todo(
    val id: Long,
    val todo: String,
    val date: String,
    val isDone: Boolean = false
)
