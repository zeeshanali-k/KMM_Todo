package com.devscion.kmmtodo.android.domain.repo

import com.devscion.kmmtodo.android.data.model.DataResponse
import com.devscion.kmmtodo.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insertTodo(todo: Todo): Flow<DataResponse<Boolean>>

}