package com.oleg.quransayaid.data.api

import com.oleg.quransayaid.data.Surah
import retrofit2.http.GET

/**
 * Crafted by Lukman on 12/01/22.
 **/

interface ApiService {

    @GET("surah")
    suspend fun getSurahes(): List<Surah>

}