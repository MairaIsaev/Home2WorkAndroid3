package com.example.home2workandroid3.ui.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.home2workandroid3.R
import com.example.home2workandroid3.adapter.BleachAdapter
import com.example.home2workandroid3.data.viewModel.BleachViewModel
import com.example.home2workandroid3.databinding.FragmentAnimeFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentAnimeFirstBinding? = null
    private val binding: FragmentAnimeFirstBinding get() = _binding!!
    private val bleachAdapter = BleachAdapter()
    private val viewModel by activityViewModels<BleachViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        toGoSecondFragment()

    }

    private fun initialize() = with(binding) {
        viewModel.bleachLiveData.observe(viewLifecycleOwner) { uiState ->
            rvFirst.adapter = bleachAdapter
            uiState.success?.let {
                bleachAdapter.setBleach(it.toMutableList())
            }
        }
    }

    private fun toGoSecondFragment() = with(binding) {
        btnFirst.setOnClickListener {
            progressbar.isVisible = true
            Handler().postDelayed(
                {
                    progressbar.isVisible = false
                    findNavController().navigate(R.id.action_firstFragment_to_animeSecondFragment)
                },
                3000
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}