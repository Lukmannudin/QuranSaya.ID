package com.oleg.quransayaid.data.ayatsource

import com.oleg.quransayaid.data.Ayat
import com.oleg.quransayaid.data.Result

/**
 * Crafted by Lukman on 08/02/22.
 **/

interface AyatDataSource {

    suspend fun fetchAyat(id: Int): Result<List<Ayat>>

}