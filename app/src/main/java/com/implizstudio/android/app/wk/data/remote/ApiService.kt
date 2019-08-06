package com.implizstudio.android.app.wk.data.remote

import com.implizstudio.android.app.wk.data.model.constant.Constant
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    fun createWarungKu(): ApiDao.WarungKu =
        Retrofit.Builder()
            .baseUrl(Constant.BaseUrl.WARUNG_KU)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor()
                        .apply { level = HttpLoggingInterceptor.Level.BODY }
                    )
                    .build()
            )
            .build()
            .create(ApiDao.WarungKu::class.java)

}