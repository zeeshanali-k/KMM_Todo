package com.devscion.kmmtodo.android.di

import com.devscion.kmmtodo.android.data.repo.TodoRepositoryImpl
import com.devscion.kmmtodo.android.domain.repo.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class TodoRepoModule {

    @Binds
    abstract fun provideTodosRepository(todoRepositoryImpl: TodoRepositoryImpl): TodoRepository

}