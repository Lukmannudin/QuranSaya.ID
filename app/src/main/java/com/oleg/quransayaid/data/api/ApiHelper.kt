package com.oleg.quransayaid.data.api

import com.oleg.quransayaid.data.Surah
import retrofit2.Response

/**
 * Crafted by Lukman on 12/01/22.
 **/

interface ApiHelper {

    suspend fun getSurah(): Response<List<Surah>>

}