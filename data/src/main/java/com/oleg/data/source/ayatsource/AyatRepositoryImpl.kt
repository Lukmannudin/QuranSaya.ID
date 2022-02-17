package com.oleg.data.source.ayatsource

import com.oleg.data.domain.Ayat
import com.oleg.data.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Crafted by Lukman on 08/02/22.
 **/

class AyatRepositoryImpl @Inject constructor(
    private val ayatDataSource: AyatDataSource
) : AyatRepository {

    override suspend fun fetchAyatList(id: Int): Flow<Result<List<Ayat>>> = flow {
        val ayatList = ayatDataSource.fetchAyat(id)
        emit(ayatList)
    }
}