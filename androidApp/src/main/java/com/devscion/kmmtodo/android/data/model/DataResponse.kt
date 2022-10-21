package com.devscion.kmmtodo.android.data.model

sealed class DataResponse<T>(val data: T?, val error: String?) {
    class Success<T>(data: T?) : DataResponse<T>(data,null)
    class Error<T>(error: String?) : DataResponse<T>(null,error)
    class Loading<T>() : DataResponse<T>(null,null)

}