package com.oleg.quransayaid.api

import com.oleg.quransayaid.data.surahsource.remote.BaseSurahResponse
import com.oleg.quransayaid.data.surahsource.remote.SurahRemote
import retrofit2.Response

/**
 * Crafted by Lukman on 12/01/22.
 **/

interface ApiHelper {
    suspend fun getSurah(): Response<BaseSurahResponse<SurahRemote>>
}