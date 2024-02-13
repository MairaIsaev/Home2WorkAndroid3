package com.example.home2workandroid3.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.home2workandroid3.data.Models
import com.example.home2workandroid3.data.repositories.BleachRepository
import com.example.home2workandroid3.utils.UiState

class BleachViewModel : ViewModel() {
    private val _bleachLiveData = MutableLiveData<UiState<List<Models>>>()
    val bleachLiveData: LiveData<UiState<List<Models>>> = _bleachLiveData
    private val bleachRepository = BleachRepository()

    init {
        getHeroes()
    }

    fun getHeroes() {

        _bleachLiveData.value = UiState(isLoading = false, success =  bleachRepository.getBleach())
    }

    fun addBleach(bleach:Models) {
        bleachRepository.addBleach(bleach)
    }

    override fun onCleared() {
        super.onCleared()
    }
}