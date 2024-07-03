package com.example.hiltapp

import com.example.hiltapp.Interface.IApiService
import com.example.hiltapp.Interface.IDataRepository
import com.example.hiltapp.Repo.DataRepository
import com.example.hiltapp.Service.ApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindApiService(apiService: ApiService): IApiService

    @Binds
    @Singleton
    abstract fun bindDataRepository(dataRepository: DataRepository): IDataRepository
}