package com.oleg.data.mapper.ayatmapper

import com.oleg.data.domain.Ayat
import com.oleg.data.mapper.base.Mapper
import com.oleg.data.mapper.base.NullableInputListMapper
import com.oleg.data.source.ayatsource.local.AyatLocal
import com.oleg.data.source.ayatsource.remote.AyatRemote

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

internal class AyatLocalToAyat : Mapper<AyatLocal, Ayat> {
    override fun map(input: AyatLocal): Ayat {
        return with(input) {
            Ayat(
                ayatNumber,
                translationText,
                arabicText
            )
        }
    }
}

internal class AyatToLocal(
    private val surahId: Int
) : Mapper<Ayat, AyatLocal> {
    
    override fun map(input: Ayat): AyatLocal {
        return with(input) {
            AyatLocal(
                ayatNumber,
                translationText,
                arabicText,
                surahId
            )
        }
    }
}

internal class AyatLocalListToAyatList(
    private val ayatRemoteMapper: Mapper<AyatLocal, Ayat>
) : NullableInputListMapper<AyatLocal, Ayat> {
    override fun map(input: List<AyatLocal>?): List<Ayat> {
        return input?.let {
            it.map { ayat ->
                ayatRemoteMapper.map(ayat)
            }
        } ?: emptyList()
    }
}