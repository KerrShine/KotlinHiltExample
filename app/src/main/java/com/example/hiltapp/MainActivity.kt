package com.example.hiltapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hiltapp.View.SecondActivity
import com.example.hiltapp.ViewModel.DataViewModel
import com.example.hiltapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnClickListener{

    private val viewModel: DataViewModel by viewModels()
    val TAG = "log"

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        viewModel.data.observe(this, Observer { post ->
            Log.d(TAG, "onCreate: " + post.toString())
            binding.tvMessage.text = post.toString()
        })

        viewModel.error.observe(this, Observer { error ->
            Log.d(TAG, "Error: $error")
            binding.tvMessage.text = error
        })

        binding.btnToSecond.setOnClickListener(this)

        viewModel.loadData()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.btnToSecond -> {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}