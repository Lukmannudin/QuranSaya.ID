package com.oleg.data.mapper.surahmapper

import com.oleg.data.Surah
import com.oleg.data.mapper.base.Mapper
import com.oleg.data.mapper.base.NullableInputListMapper
import com.oleg.data.source.surahsource.remote.SurahRemote

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