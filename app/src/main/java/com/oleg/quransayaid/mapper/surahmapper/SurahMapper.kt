package com.oleg.quransayaid.mapper.surahmapper

import com.oleg.quransayaid.data.Surah
import com.oleg.quransayaid.data.surahsource.remote.SurahRemote

/**
 * Crafted by Lukman on 07/02/22.
 **/

object SurahMapper {
    fun List<SurahRemote>?.mapToSurahes(): List<Surah> {
        return this?.let { surahRemotes ->
            SurahesRemoteToSurahes(SurahRemoteToSurah()).map(surahRemotes)
        } ?: emptyList()
    }
}