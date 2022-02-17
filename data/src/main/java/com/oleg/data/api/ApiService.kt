package com.oleg.data.api

import com.oleg.data.source.ayatsource.remote.AyatDataRemote
import com.oleg.data.source.ayatsource.remote.BaseAyatResponse
import com.oleg.data.source.surahsource.remote.BaseSurahResponse
import com.oleg.data.source.surahsource.remote.SurahRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Crafted by Lukman on 12/01/22.
 **/

interface ApiService {

    @GET("/list")
    suspend fun getSurahes(): Response<BaseSurahResponse<SurahRemote>>

    @GET("/surah/{id}")
    suspend fun getSurahById(@Path("id") id: Int): Response<BaseAyatResponse<AyatDataRemote>>

}