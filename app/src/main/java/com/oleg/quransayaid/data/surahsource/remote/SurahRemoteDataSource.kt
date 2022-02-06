package com.oleg.quransayaid.data.surahsource.remote

import com.oleg.quransayaid.api.ApiHelper
import com.oleg.quransayaid.data.Result
import com.oleg.quransayaid.data.Surah
import com.oleg.quransayaid.data.surahsource.SurahDataSource
import com.oleg.quransayaid.mapper.surahmapper.SurahMapper.mapToSurahes
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