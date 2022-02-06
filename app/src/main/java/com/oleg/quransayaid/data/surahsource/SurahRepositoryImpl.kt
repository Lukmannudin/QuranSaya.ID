package com.oleg.quransayaid.data.surahsource

import com.oleg.quransayaid.data.Result
import com.oleg.quransayaid.data.Surah
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Crafted by Lukman on 06/02/22.
 **/

class SurahRepositoryImpl @Inject constructor(
    private val surahDataSource: SurahDataSource
) : SurahRepository {
    override suspend fun fetchSurahes(): Flow<Result<List<Surah>>> = flow {
        val surahes = surahDataSource.fetchSurahes()
        emit(surahes)
    }
}