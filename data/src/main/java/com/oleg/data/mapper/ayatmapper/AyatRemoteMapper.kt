package com.oleg.data.mapper.ayatmapper

import com.oleg.data.Ayat
import com.oleg.data.mapper.base.Mapper
import com.oleg.data.mapper.base.NullableInputListMapper
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