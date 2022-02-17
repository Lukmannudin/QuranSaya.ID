package com.oleg.data.source.surahsource

import com.oleg.data.common.Result
import com.oleg.data.domain.Surah
import com.oleg.data.source.surahsource.local.SurahLocalDataSource
import com.oleg.data.source.surahsource.remote.SurahRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Crafted by Lukman on 06/02/22.
 **/

class SurahRepositoryImpl @Inject constructor(
    private val surahRemoteDataSource: SurahRemoteDataSource,
    private val surahLocalDataSource: SurahLocalDataSource
) : SurahRepository {
    override suspend fun fetchSurahes(): Flow<Result<List<Surah>>> = flow {
        val surahLocal = surahLocalDataSource.fetchSurahes()

        var isNeedReload = false

        when (surahLocal) {
            is Result.Success -> {
                if (surahLocal.data.isNotEmpty()) {
                    emit(surahLocal)
                } else {
                    isNeedReload = true
                }
            }
            else -> {
                isNeedReload = true
            }
        }

        if (isNeedReload) {
            emit(fetchFromRemote())
        }
    }

    private suspend fun fetchFromRemote(): Result<List<Surah>> {
        return when (val surahRemoteList = surahRemoteDataSource.fetchSurahList()) {
            is Result.Success -> {
                surahLocalDataSource.saveAll(surahRemoteList.data)
                surahRemoteList
            }
            else -> {
                surahRemoteList
            }
        }
    }
}