package com.oleg.quransayaid.ui.ayatread

import androidx.recyclerview.widget.RecyclerView
import com.oleg.quransayaid.databinding.ItemAyatBinding

/**
 * Crafted by Lukman on 15/02/22.
 **/

class AyatReadViewHolder(
    private val itemAyatBinding: ItemAyatBinding
) : RecyclerView.ViewHolder(itemAyatBinding.root) {

    fun bind(ayat: com.oleg.data.Ayat) {
        with(itemAyatBinding){
            ayatNumber.text = ayat.ayatNumber.toString()
            ayatArabicText.text = ayat.arabicText
            ayatTranslatedText.text = ayat.translationText
        }
    }

}