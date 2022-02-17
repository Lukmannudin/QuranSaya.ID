package com.oleg.data.source.surahsource

import com.oleg.data.Result
import com.oleg.data.Surah

/**
 * Crafted by Lukman on 17/01/22.
 **/

interface SurahDataSource {

    suspend fun fetchSurahes(): Result<List<Surah>>

}