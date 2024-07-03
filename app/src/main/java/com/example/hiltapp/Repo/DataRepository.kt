package com.example.hiltapp.Repo


import com.example.hiltapp.Interface.IApiService
import com.example.hiltapp.Interface.IDataRepository
import com.example.hiltapp.Model.PostModel
import com.example.hiltapp.Service.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val apiService: IApiService) : IDataRepository {
    override suspend fun fetchPost(): PostModel {
        return apiService.fetchData("https://jsonplaceholder.typicode.com/posts/1", PostModel::class.java)
    }
}