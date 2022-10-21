package com.devscion.kmmtodo.data.db

import android.content.Context
import com.devscoion.kmmtodo.database.TodosDB
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(TodosDB.Schema, context, "todos.db")
    }
}