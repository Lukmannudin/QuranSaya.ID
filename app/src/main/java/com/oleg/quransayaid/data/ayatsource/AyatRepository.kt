package com.oleg.quransayaid.data.ayatsource

import com.oleg.quransayaid.data.Ayat
import com.oleg.quransayaid.data.Result
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Lukman on 08/02/22.
 **/

interface AyatRepository {

    suspend fun fetchAyatList(id: Int): Flow<Result<List<Ayat>>>

}