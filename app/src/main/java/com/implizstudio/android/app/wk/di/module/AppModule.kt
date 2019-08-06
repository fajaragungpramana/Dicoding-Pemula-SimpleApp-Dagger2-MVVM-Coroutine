package com.implizstudio.android.app.wk.di.module

import com.implizstudio.android.app.wk.data.remote.ApiService
import com.implizstudio.android.app.wk.data.repository.WarungKuRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class
    ]
)
class AppModule {

    @Singleton
    @Provides
    fun provideWarungKuRepository(service: ApiService) =  WarungKuRepository(service.createWarungKu())

}