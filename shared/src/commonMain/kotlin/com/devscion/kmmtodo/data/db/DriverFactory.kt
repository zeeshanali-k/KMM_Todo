package com.devscion.kmmtodo.data.db

import com.devscoion.kmmtodo.database.TodosDB
import com.squareup.sqldelight.db.SqlDriver


expect class DriverFactory {
    fun createDriver(): SqlDriver
}
////
fun createDatabase(driverFactory : DriverFactory): TodosDB {
    val driver = driverFactory.createDriver()
    val database = TodosDB(driver)
    // Do more work with the database (see below).

    return database
}