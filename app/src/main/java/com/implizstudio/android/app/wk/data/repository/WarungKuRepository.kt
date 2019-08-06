package com.implizstudio.android.app.wk.data.repository

import com.implizstudio.android.app.wk.data.model.StockResponse
import com.implizstudio.android.app.wk.data.model.UserResponse
import com.implizstudio.android.app.wk.data.remote.ApiDao
import com.implizstudio.android.app.wk.data.remote.ApiResponse

class WarungKuRepository(private val warungKuDao: ApiDao.WarungKu) {

    suspend fun getUser(id: String?): ApiResponse<UserResponse?> {
        val response = warungKuDao.getUserAsync(id).await()

        return if (response.isSuccessful)
            ApiResponse.Success(response.body())
        else
            ApiResponse.Failure(response.message(), response.code())
    }

    suspend fun getStocks(name: String?): ApiResponse<StockResponse?> {
        val response = warungKuDao.getStockAsync(name).await()

        return if (response.isSuccessful)
            ApiResponse.Success(response.body())
        else
            ApiResponse.Failure(response.message(), response.code())
    }

    suspend fun getStockDetail(id: String?): ApiResponse<StockResponse?> {
        val response = warungKuDao.getStockDetailAsync(id).await()

        return if (response.isSuccessful)
            ApiResponse.Success(response.body())
        else
            ApiResponse.Failure(response.message(), response.code())
    }

}