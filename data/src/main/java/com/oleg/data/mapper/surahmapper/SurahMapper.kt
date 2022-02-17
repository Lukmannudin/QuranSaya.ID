package com.oleg.data.mapper.surahmapper

import com.oleg.data.Surah
import com.oleg.data.source.surahsource.remote.SurahRemote

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