package com.oleg.quransayaid.data.ayatsource

import com.oleg.quransayaid.data.Ayat
import com.oleg.quransayaid.data.Result
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