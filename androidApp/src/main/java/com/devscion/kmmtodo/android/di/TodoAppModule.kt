package com.devscion.kmmtodo.android.di

import android.content.Context
import com.devscion.kmmtodo.data.db.DriverFactory
import com.devscion.kmmtodo.data.db.TodosDBController
import com.devscoion.kmmtodo.database.TodosDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class TodoAppModule {

    @Provides
    @Singleton
    fun provideTodosController(@ApplicationContext context: Context): TodosDBController {
        return TodosDBController(
            TodosDB(
                DriverFactory(context).createDriver()
            )
        )
    }



}