package com.oleg.quransayaid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.oleg.data.Surah
import com.oleg.quransayaid.databinding.ItemSurahBinding

/**
 * Crafted by Lukman on 07/02/22.
 **/

class HomeAdapter : ListAdapter<Surah, HomeViewHolder>(HomeItemDiffCallback()) {

    lateinit var onItemClick: (surahId: Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemSurahBinding.inflate(layoutInflater, parent, false)
        return HomeViewHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount() = currentList.size

    class HomeItemDiffCallback : DiffUtil.ItemCallback<Surah>() {
        override fun areItemsTheSame(oldItem: Surah, newItem: Surah): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Surah, newItem: Surah): Boolean {
            return oldItem == newItem
        }
    }
}