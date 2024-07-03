package com.example.hiltapp.Service

import com.example.hiltapp.Interface.IApiService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor() : IApiService {
    private val client = OkHttpClient()
    private val gson = Gson()

    override suspend fun <T> fetchData(url: String, clazz: Class<T>): T {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url(url)
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body?.string() ?: throw IOException("Empty response")
            gson.fromJson(responseBody, clazz)
        }
    }
}