package com.oleg.quransayaid.data.surahsource

import com.oleg.quransayaid.data.Result
import com.oleg.quransayaid.data.Surah

/**
 * Crafted by Lukman on 17/01/22.
 **/

interface SurahDataSource {

    suspend fun fetchSurahes(): Result<List<Surah>>

}