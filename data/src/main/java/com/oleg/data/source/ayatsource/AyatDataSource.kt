package com.oleg.data.source.ayatsource

import com.oleg.data.domain.Ayat
import com.oleg.data.common.Result

/**
 * Crafted by Lukman on 08/02/22.
 **/

interface AyatDataSource {

    suspend fun fetchAyat(id: Int): Result<List<Ayat>>

}