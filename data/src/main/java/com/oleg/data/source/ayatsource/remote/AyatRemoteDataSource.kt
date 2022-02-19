package com.oleg.data.source.ayatsource.remote

import com.oleg.data.domain.Ayat
import com.oleg.data.common.Result
import com.oleg.data.api.ApiHelper
import com.oleg.data.mapper.ayatmapper.AyatMapper.mapRemoteListToAyatList
import javax.inject.Inject

/**
 * Crafted by Lukman on 08/02/22.
 **/

class AyatRemoteDataSource @Inject constructor(
    private val apiHelper: ApiHelper
) {

    suspend fun fetchAyatList(id: Int): Result<List<Ayat>> {
        return try {
            val ayatDataResponse = apiHelper.getAyat(id)
            if (ayatDataResponse.isSuccessful) {
                val ayatData = ayatDataResponse.body()?.data
                Result.Success(ayatData?.listAyatRemote.mapRemoteListToAyatList())
            } else {
                Result.Error(Exception())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(e)
        }
    }
}