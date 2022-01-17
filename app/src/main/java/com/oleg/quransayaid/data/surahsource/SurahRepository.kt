package com.oleg.quransayaid.data.surahsource

import com.oleg.quransayaid.data.Result
import com.oleg.quransayaid.data.Surah
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Lukman on 17/01/22.
 **/

interface SurahRepository {

    suspend fun fetchSurahes(): Flow<Result<List<Surah>>>

}