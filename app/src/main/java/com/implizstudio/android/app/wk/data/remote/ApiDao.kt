package com.implizstudio.android.app.wk.data.remote

import com.implizstudio.android.app.wk.data.model.StockResponse
import com.implizstudio.android.app.wk.data.model.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDao {

    interface WarungKu {

        @GET("user")
        fun getUserAsync(@Query("id") id: String?): Deferred<Response<UserResponse>>

        @GET("stock")
        fun getStockAsync(@Query("name") name: String?): Deferred<Response<StockResponse>>

        @GET("stock/detail")
        fun getStockDetailAsync(@Query("id") id: String?): Deferred<Response<StockResponse>>

    }

}