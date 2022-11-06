package com.devscion.kmmtodo.data.db

import com.devscoion.kmmtodo.database.TodosDB

class DBModule {

    private val driverFactory by lazy {
        DriverFactory().createDriver()
    }
    val todosDBController: TodosDBController by lazy {
        TodosDBController(
            TodosDB(
                driverFactory
            )
        )
    }

}