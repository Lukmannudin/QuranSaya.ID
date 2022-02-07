package com.oleg.quransayaid.mapper.ayatmapper

import com.oleg.quransayaid.data.Ayat
import com.oleg.quransayaid.data.Surah
import com.oleg.quransayaid.data.ayatsource.remote.AyatRemote
import com.oleg.quransayaid.data.surahsource.remote.SurahRemote
import com.oleg.quransayaid.mapper.base.Mapper
import com.oleg.quransayaid.mapper.base.NullableInputListMapper

/**
 * Crafted by Lukman on 08/02/22.
 **/

internal class AyatRemoteToAyat : Mapper<AyatRemote, Ayat> {
    override fun map(input: AyatRemote): Ayat {
        return with(input) {
            Ayat(
                ayatNumber!!,
                translationText!!,
                arabicText!!
            )
        }
    }
}

internal class AyatListRemoteToAyatList(
    private val ayatRemoteMapper: Mapper<AyatRemote, Ayat>
) : NullableInputListMapper<AyatRemote, Ayat> {
    override fun map(input: List<AyatRemote>?): List<Ayat> {
        return input?.let {
            it.map { ayat ->
                ayatRemoteMapper.map(ayat)
            }
        } ?: emptyList()
    }
}