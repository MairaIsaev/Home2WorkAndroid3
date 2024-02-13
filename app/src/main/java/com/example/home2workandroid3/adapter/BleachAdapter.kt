package com.example.home2workandroid3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.home2workandroid3.data.Models
import com.example.home2workandroid3.databinding.ItemBinding

class BleachAdapter : RecyclerView.Adapter<BleachAdapter.BleachViewHolder>() {
    private var bleachList = mutableListOf<Models>()

    fun setBleach(bleachList: MutableList<Models>) {
        this.bleachList = bleachList
        notifyDataSetChanged()
    }

    inner class BleachViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(bleachData: Models) {
            binding.ivItem.setImageResource(bleachData.image)
            binding.textItem.text = bleachData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BleachViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BleachViewHolder(binding)
    }

    override fun getItemCount() = bleachList.size

    override fun onBindViewHolder(holder: BleachViewHolder, position: Int) {
        holder.onBind(bleachList[position])
    }
}