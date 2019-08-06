package com.implizstudio.android.app.wk.di.module

import com.implizstudio.android.app.wk.data.remote.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideService() = ApiService

}