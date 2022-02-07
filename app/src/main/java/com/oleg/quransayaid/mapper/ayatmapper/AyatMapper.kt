package com.oleg.quransayaid.mapper.ayatmapper

import com.oleg.quransayaid.data.Ayat
import com.oleg.quransayaid.data.ayatsource.remote.AyatRemote

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