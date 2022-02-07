package com.oleg.quransayaid.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oleg.quransayaid.data.Surah
import com.oleg.quransayaid.databinding.ItemSurahBinding

/**
 * Crafted by Lukman on 07/02/22.
 **/

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {

    private val surahList: MutableList<Surah> = mutableListOf()

    lateinit var onItemClick: (surahId: Int) -> Unit

    fun setData(surahList: List<Surah>) {
        this.surahList.addAll(surahList)
        notifyItemRangeInserted(0, surahList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemSurahBinding.inflate(layoutInflater, parent, false)
        return HomeViewHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(surahList[position])
    }

    override fun getItemCount() = surahList.size
}