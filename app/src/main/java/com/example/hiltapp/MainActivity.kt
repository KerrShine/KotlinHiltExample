package com.example.hiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hiltapp.ViewModel.DataViewModel
import com.example.hiltapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DataViewModel by viewModels()
    val TAG = "log"

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        viewModel.data.observe(this, Observer { post ->
            Log.d(TAG, "onCreate: " + post.toString())
        })

        viewModel.error.observe(this, Observer { error ->
            Log.d(TAG, "Error: $error")
        })

        viewModel.loadData()
    }
}