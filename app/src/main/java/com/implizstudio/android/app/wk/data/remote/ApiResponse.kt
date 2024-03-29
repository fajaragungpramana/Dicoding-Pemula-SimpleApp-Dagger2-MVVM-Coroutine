package com.implizstudio.android.app.wk.data.remote

sealed class ApiResponse<T> {

    data class Success<T>(val body: T): ApiResponse<T>()
    data class Failure<T>(val message: String, val code: Int): ApiResponse<T>()

}