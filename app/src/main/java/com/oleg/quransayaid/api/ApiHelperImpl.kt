package com.oleg.quransayaid.api

import com.oleg.quransayaid.data.ayatsource.remote.AyatDataRemote
import com.oleg.quransayaid.data.ayatsource.remote.BaseAyatResponse
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

    override suspend fun getAyat(id: Int): Response<BaseAyatResponse<AyatDataRemote>> {
        return apiService.getSurahById(id)
    }
}