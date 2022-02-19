package com.oleg.data.source.ayatsource

import com.oleg.data.common.Result
import com.oleg.data.domain.Ayat
import com.oleg.data.source.ayatsource.local.AyatLocalDataSource
import com.oleg.data.source.ayatsource.remote.AyatRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Crafted by Lukman on 08/02/22.
 **/

class AyatRepositoryImpl @Inject constructor(
    private val ayatRemoteDataSource: AyatRemoteDataSource,
    private val ayatLocalDataSource: AyatLocalDataSource
) : AyatRepository {
    
    override suspend fun fetchAyatList(surahId: Int): Flow<Result<List<Ayat>>> = flow {
        val ayatList = ayatLocalDataSource.fetchAyatList(surahId)
        var isNeedReload = false
        
        when (ayatList) {
            is Result.Success -> {
                if (ayatList.data.isNotEmpty()) {
                    emit(ayatList)
                } else {
                    isNeedReload = true
                }
            }
            else -> {
                isNeedReload = true
            }
        }
        
        if (isNeedReload) {
            emit(fetchFromRemote(surahId))
        }
    }
    
    private suspend fun fetchFromRemote(id: Int): Result<List<Ayat>> {
        return when (val ayatRemoteList = ayatRemoteDataSource.fetchAyatList(id)) {
            is Result.Success -> {
                ayatLocalDataSource.saveAll(id, ayatRemoteList.data)
                ayatRemoteList
            }
            else -> ayatRemoteList
        }
    }
}