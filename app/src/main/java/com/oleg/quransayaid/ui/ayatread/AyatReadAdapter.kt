package com.oleg.quransayaid.ui.ayatread

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.oleg.data.domain.Ayat
import com.oleg.quransayaid.databinding.ItemAyatBinding

/**
 * Crafted by Lukman on 15/02/22.
 **/

class AyatReadAdapter : ListAdapter<Ayat, AyatReadViewHolder>(AyatDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyatReadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemAyatBinding.inflate(layoutInflater, parent, false)
        return AyatReadViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AyatReadViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class AyatDiffUtilCallback: DiffUtil.ItemCallback<Ayat>() {
        override fun areItemsTheSame(oldItem: Ayat, newItem: Ayat): Boolean {
            return oldItem.ayatNumber == newItem.ayatNumber
        }

        override fun areContentsTheSame(oldItem: Ayat, newItem: Ayat): Boolean {
            return oldItem == newItem
        }
    }

}