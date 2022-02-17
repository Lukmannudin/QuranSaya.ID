package com.oleg.data.api

import com.oleg.data.source.ayatsource.remote.AyatDataRemote
import com.oleg.data.source.ayatsource.remote.BaseAyatResponse
import com.oleg.data.source.surahsource.remote.BaseSurahResponse
import com.oleg.data.source.surahsource.remote.SurahRemote
import retrofit2.Response
import javax.inject.Inject

/**
 * Crafted by Lukman on 12/01/22.
 **/

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {

    override suspend fun getSurah(): Response<BaseSurahResponse<SurahRemote>> {
        return apiService.getSurahes()
    }

    override suspend fun getAyat(id: Int): Response<BaseAyatResponse<AyatDataRemote>> {
        return apiService.getSurahById(id)
    }
}