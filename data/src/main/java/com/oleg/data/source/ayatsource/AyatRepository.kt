package com.oleg.data.source.ayatsource

import com.oleg.data.domain.Ayat
import com.oleg.data.common.Result
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Lukman on 08/02/22.
 **/

interface AyatRepository {

    suspend fun fetchAyatList(surahId: Int): Flow<Result<List<Ayat>>>

}