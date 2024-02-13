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
import com.example.home2workandroid3.data.Models
import com.example.home2workandroid3.data.viewModel.BleachViewModel
import com.example.home2workandroid3.databinding.FragmentAnimeSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentAnimeSecondBinding? = null
    private val binding: FragmentAnimeSecondBinding get() = _binding!!
    private val viewModel by activityViewModels<BleachViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()

    }

    private fun goBack() = with(binding) {
        binding.btnSec.setOnClickListener {
            progressbar2.isVisible = true
            Handler().postDelayed({
                progressbar2.isVisible = false
                viewModel.addBleach(Models(
                    image = R.drawable.img,
                    edinName.text.toString().trim()
                ))

                findNavController().navigateUp()
            }, 2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}