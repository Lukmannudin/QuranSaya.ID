package com.oleg.data.mapper.surahmapper

import com.oleg.data.domain.Surah
import com.oleg.data.mapper.base.Mapper
import com.oleg.data.mapper.base.NullableInputListMapper
import com.oleg.data.source.surahsource.local.SurahLocal

/**
 * Crafted by Lukman on 17/02/22.
 **/

internal class SurahLocalToSurah : Mapper<SurahLocal, Surah> {
    override fun map(input: SurahLocal): Surah {
        return with(input) {
            Surah(
                id,
                latin,
                translation,
                arabic,
                ayatCount
            )
        }
    }
}

internal class SurahListLocalToSurahList(
    private val surahRemoteMapper: Mapper<SurahLocal, Surah>
) : NullableInputListMapper<SurahLocal, Surah> {
    override fun map(input: List<SurahLocal>?): List<Surah> {
        return input?.let {
            it.map { surah ->
                surahRemoteMapper.map(surah)
            }
        } ?: emptyList()
    }
}

internal class SurahToSurahLocal : Mapper<Surah, SurahLocal> {
    override fun map(input: Surah): SurahLocal {
        return with(input) {
            SurahLocal(
                id,
                latin,
                translation,
                arabic,
                ayatCount
            )
        }
    }
}

internal class SurahListToSurahLocalList(
    private val surahRemoteMapper: Mapper<Surah, SurahLocal>
) : NullableInputListMapper<Surah, SurahLocal> {
    override fun map(input: List<Surah>?): List<SurahLocal> {
        return input?.let {
            it.map { surah ->
                surahRemoteMapper.map(surah)
            }
        } ?: emptyList()
    }
}
