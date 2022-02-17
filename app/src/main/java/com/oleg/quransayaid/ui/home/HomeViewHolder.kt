package com.oleg.quransayaid.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.oleg.quransayaid.databinding.ItemSurahBinding

/**
 * Crafted by Lukman on 07/02/22.
 **/

class HomeViewHolder(
    private val binding: ItemSurahBinding,
    private val onItemClick: (surahId: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(surah: com.oleg.data.Surah) {
        with(binding) {
            surahId.text = surah.id.toString()
            surahNameLatin.text = surah.latin
            surahNameArabic.text = surah.arabic
            ayatCount.text = "${surah.ayatCount} ayat"

            binding.root.setOnClickListener {
                onItemClick.invoke(surah.id)
            }
        }
    }
}