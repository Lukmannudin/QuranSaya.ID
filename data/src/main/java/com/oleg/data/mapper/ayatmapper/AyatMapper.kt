package com.oleg.data.mapper.ayatmapper

import com.oleg.data.domain.Ayat
import com.oleg.data.source.ayatsource.local.AyatLocal
import com.oleg.data.source.ayatsource.remote.AyatRemote

/**
 * Crafted by Lukman on 08/02/22.
 **/

object AyatMapper {
    fun List<AyatRemote>?.mapRemoteListToAyatList(): List<Ayat> {
        return this?.let { ayatListRemote ->
            AyatListRemoteToAyatList(AyatRemoteToAyat()).map(ayatListRemote)
        } ?: emptyList()
    }
    
    fun List<AyatLocal>.mapLocalListToAyatList(): List<Ayat> {
        return AyatLocalListToAyatList(AyatLocalToAyat()).map(this)
    }
    
    fun Ayat.mapToLocal(surahId: Int): AyatLocal {
        return AyatToLocal(surahId).map(this)
    }
}