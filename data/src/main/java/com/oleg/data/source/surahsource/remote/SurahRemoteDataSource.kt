package com.oleg.data.source.surahsource.remote

import com.oleg.data.common.Result
import com.oleg.data.domain.Surah
import com.oleg.data.api.ApiHelper
import com.oleg.data.mapper.surahmapper.SurahMapper.mapRemoteToSurahes
import javax.inject.Inject

/**
 * Crafted by Lukman on 06/02/22.
 **/

class SurahRemoteDataSource @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun fetchSurahList(): Result<List<Surah>> {
        return try {
            val surahes = apiHelper.getSurah()
            if (surahes.isSuccessful) {
                val surahesData = surahes.body()?.data
                Result.Success(surahesData.mapRemoteToSurahes())
            } else {
                Result.Error(Exception())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(e)
        }
    }
}