package com.oleg.data.api

import com.oleg.data.source.ayatsource.remote.AyatDataRemote
import com.oleg.data.source.ayatsource.remote.BaseAyatResponse
import com.oleg.data.source.surahsource.remote.BaseSurahResponse
import com.oleg.data.source.surahsource.remote.SurahRemote
import retrofit2.Response

/**
 * Crafted by Lukman on 12/01/22.
 **/

interface ApiHelper {

    suspend fun getSurah(): Response<BaseSurahResponse<SurahRemote>>

    suspend fun getAyat(id: Int): Response<BaseAyatResponse<AyatDataRemote>>
}