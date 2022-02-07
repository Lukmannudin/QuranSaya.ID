package com.oleg.quransayaid.data.ayatsource.remote

import com.oleg.quransayaid.api.ApiHelper
import com.oleg.quransayaid.data.Ayat
import com.oleg.quransayaid.data.Result
import com.oleg.quransayaid.data.ayatsource.AyatDataSource
import com.oleg.quransayaid.mapper.ayatmapper.AyatMapper.mapToAyatListRemote
import javax.inject.Inject

/**
 * Crafted by Lukman on 08/02/22.
 **/

class AyatRemoteDataSource @Inject constructor(
    private val apiHelper: ApiHelper
) : AyatDataSource {

    override suspend fun fetchAyat(id: Int): Result<List<Ayat>> {
        return try {
            val ayatDataResponse = apiHelper.getAyat(id)
            if (ayatDataResponse.isSuccessful) {
                val ayatData = ayatDataResponse.body()?.data
                Result.Success(ayatData?.listAyatRemote.mapToAyatListRemote())
            } else {
                Result.Error(Exception())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(e)
        }
    }
}