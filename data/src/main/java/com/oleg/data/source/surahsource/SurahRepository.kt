package com.oleg.data.source.surahsource

import com.oleg.data.Result
import com.oleg.data.Surah
import kotlinx.coroutines.flow.Flow

/**
 * Crafted by Lukman on 17/01/22.
 **/

interface SurahRepository {

    suspend fun fetchSurahes(): Flow<Result<List<Surah>>>

}