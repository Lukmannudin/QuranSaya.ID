package com.oleg.data.source.ayatsource

import com.oleg.data.Ayat
import com.oleg.data.Result

/**
 * Crafted by Lukman on 08/02/22.
 **/

interface AyatDataSource {

    suspend fun fetchAyat(id: Int): Result<List<Ayat>>

}