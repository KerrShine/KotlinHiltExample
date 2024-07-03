package com.example.hiltapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiltapp.R
import com.example.hiltapp.ViewModel.DataViewModel
import com.example.hiltapp.databinding.ActivityMainBinding
import com.example.hiltapp.databinding.ActivitySecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment())
                .commit()
        }

    }
}