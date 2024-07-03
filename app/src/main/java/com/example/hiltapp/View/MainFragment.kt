package com.example.hiltapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.hiltapp.R
import com.example.hiltapp.ViewModel.DataViewModel
import com.example.hiltapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() , OnClickListener{

    private var _binding: FragmentMainBinding? =null
    private val binding get() = _binding!!
    private val viewModel: DataViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFetchData.setOnClickListener(this)

        // 觀察 ViewModel 數據變化
        viewModel.data.observe(viewLifecycleOwner, { post ->
            binding.tvMessage.text = "Title: ${post.title}\n\nBody: ${post.body}"
        })

        viewModel.error.observe(viewLifecycleOwner, { error ->
            binding.tvMessage.text = "Error: $error"
        })

    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnFetchData ->{
                viewModel.loadData()
            }
        }
    }


}