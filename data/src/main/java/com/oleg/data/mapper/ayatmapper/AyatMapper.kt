package com.oleg.data.mapper.ayatmapper

import com.oleg.data.Ayat
import com.oleg.data.source.ayatsource.remote.AyatRemote

/**
 * Crafted by Lukman on 08/02/22.
 **/

object AyatMapper {
    fun List<AyatRemote>?.mapToAyatListRemote(): List<Ayat> {
        return this?.let { ayatListRemote ->
            AyatListRemoteToAyatList(AyatRemoteToAyat()).map(ayatListRemote)
        } ?: emptyList()
    }
}