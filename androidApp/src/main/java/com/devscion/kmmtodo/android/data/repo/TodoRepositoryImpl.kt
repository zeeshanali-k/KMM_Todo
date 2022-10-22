package com.devscion.kmmtodo.android.data.repo

import com.devscion.kmmtodo.android.data.model.DataResponse
import com.devscion.kmmtodo.android.domain.repo.TodoRepository
import com.devscion.kmmtodo.data.db.TodosDBController
import com.devscion.kmmtodo.model.Todo
import com.devscion.kmmtodo.utils.logAll
import com.devscoion.kmmtodo.database.TodosDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class TodoRepositoryImpl @Inject constructor(
    private val todosDBController: TodosDBController
) : TodoRepository {
    private val TAG = "TodoRepositoryImpl"
    override suspend fun insertTodo(todo: String): Flow<DataResponse<Boolean>> = flow {
        try {
            todosDBController.addTodo(todo)
            emit(
                DataResponse.Success(
                    true
                )
            )
        } catch (e: Exception) {
            e logAll TAG
            emit(DataResponse.Error(e.localizedMessage ?: "Failed to save Todo"))
        }
    }

    override suspend fun getAllTodos(): Flow<DataResponse<List<Todo>>> = flow {
        try {
            emit(DataResponse.Success(todosDBController.getTodos()))
        } catch (e: Exception) {
            e logAll TAG
            emit(DataResponse.Error(e.localizedMessage ?: "Failed to load Todos"))
        }
    }


}