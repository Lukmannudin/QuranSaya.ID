package com.oleg.quransayaid.mapper.surahmapper

import com.oleg.quransayaid.data.Surah
import com.oleg.quransayaid.data.surahsource.remote.SurahRemote
import com.oleg.quransayaid.mapper.base.Mapper
import com.oleg.quransayaid.mapper.base.NullableInputListMapper

/**
 * Crafted by Lukman on 07/02/22.
 **/


internal class SurahRemoteToSurah : Mapper<SurahRemote, Surah> {
    override fun map(input: SurahRemote): Surah {
        return with(input) {
            Surah(
                id!!,
                latin!!,
                translation!!,
                arabic!!,
                ayahCount!!
            )
        }
    }
}

internal class SurahesRemoteToSurahes(
    private val surahRemoteMapper: Mapper<SurahRemote, Surah>
) : NullableInputListMapper<SurahRemote, Surah> {
    override fun map(input: List<SurahRemote>?): List<Surah> {
        return input?.let {
            it.map { surah ->
                surahRemoteMapper.map(surah)
            }
        } ?: emptyList()
    }
}