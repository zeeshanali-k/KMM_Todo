package com.devscion.kmmtodo.data.db

import com.devscoion.kmmtodo.database.TodosDB
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(TodosDB.Schema, "todos.db")
    }
}