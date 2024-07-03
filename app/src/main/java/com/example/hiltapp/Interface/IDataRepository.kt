package com.example.hiltapp.Interface

import com.example.hiltapp.Model.PostModel

interface IDataRepository {
    suspend fun fetchPost(): PostModel
}