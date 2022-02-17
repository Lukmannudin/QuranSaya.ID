package com.oleg.data.mapper.surahmapper

import com.oleg.data.domain.Surah
import com.oleg.data.source.surahsource.local.SurahLocal
import com.oleg.data.source.surahsource.remote.SurahRemote

/**
 * Crafted by Lukman on 07/02/22.
 **/

object SurahMapper {
    fun List<SurahRemote>?.mapRemoteToSurahes(): List<Surah> {
        return this?.let { surahRemoteList ->
            SurahListRemoteToSurahList(SurahRemoteToSurah()).map(surahRemoteList)
        } ?: emptyList()
    }

    fun List<SurahLocal>.mapLocalToSurahes(): List<Surah> {
        return this.let { surahLocalList ->
            SurahListLocalToSurahList(SurahLocalToSurah()).map(surahLocalList)
        }
    }

    fun List<Surah>.mapDomainListToLocalList(): List<SurahLocal> {
        return SurahListToSurahLocalList(SurahToSurahLocal()).map(this)
    }

    fun Surah.mapToLocal(): SurahLocal {
        return SurahToSurahLocal().map(this)
    }
}