package com.example.hiltapp.Interface

interface IApiService {

    suspend fun <T> fetchData(url: String, clazz: Class<T>): T
}