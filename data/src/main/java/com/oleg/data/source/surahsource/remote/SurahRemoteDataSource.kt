package com.oleg.data.source.surahsource.remote

import com.oleg.data.Result
import com.oleg.data.Surah
import com.oleg.data.api.ApiHelper
import com.oleg.data.mapper.surahmapper.SurahMapper.mapToSurahes
import com.oleg.data.source.surahsource.SurahDataSource
import javax.inject.Inject

/**
 * Crafted by Lukman on 06/02/22.
 **/

class SurahRemoteDataSource @Inject constructor(
    private val apiHelper: ApiHelper
) : SurahDataSource {
    override suspend fun fetchSurahes(): Result<List<Surah>> {
        return try {
            val surahes = apiHelper.getSurah()
            if (surahes.isSuccessful) {
                val surahesData = surahes.body()?.data
                Result.Success(surahesData.mapToSurahes())
            } else {
                Result.Error(Exception())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(e)
        }
    }
}