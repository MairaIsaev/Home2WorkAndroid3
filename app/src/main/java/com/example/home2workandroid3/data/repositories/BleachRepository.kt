package com.example.home2workandroid3.data.repositories

import com.example.home2workandroid3.R
import com.example.home2workandroid3.data.Models

class BleachRepository {
    private val heroes = mutableListOf<Models>(
        Models(R.drawable.img, "ичиго"),
        Models(R.drawable.img_1, "Яхве"),
    )

    fun addBleach(bleach: Models) {
        heroes.add(bleach)
    }

    fun getBleach() = heroes
}