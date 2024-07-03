package com.example.hiltapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltapp.Model.PostModel
import com.example.hiltapp.Repo.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel  @Inject constructor(private val repository: DataRepository) : ViewModel() {
    private val _data = MutableLiveData<PostModel>()
    val data: LiveData<PostModel> get() = _data

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun loadData() {
        viewModelScope.launch {
            try {
                val result = repository.fetchPost()
                _data.value = result
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}