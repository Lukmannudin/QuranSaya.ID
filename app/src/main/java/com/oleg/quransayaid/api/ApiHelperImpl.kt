package com.oleg.quransayaid.api

import com.oleg.quransayaid.data.surahsource.remote.BaseSurahResponse
import com.oleg.quransayaid.data.surahsource.remote.SurahRemote
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
}