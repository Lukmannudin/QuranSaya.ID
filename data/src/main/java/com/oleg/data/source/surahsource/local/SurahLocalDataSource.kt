package com.oleg.data.source.surahsource.local

import android.database.sqlite.SQLiteException
import com.oleg.data.common.Result
import com.oleg.data.domain.Surah
import com.oleg.data.mapper.surahmapper.SurahMapper.mapLocalToSurahes
import com.oleg.data.mapper.surahmapper.SurahMapper.mapToLocal
import javax.inject.Inject

/**
 * Crafted by Lukman on 17/02/22.
 **/

class SurahLocalDataSource @Inject constructor(
    private val surahDao: SurahDao
) {
    suspend fun fetchSurahList(): Result<List<Surah>> {
        return try {
            val surahList = surahDao.getAll().mapLocalToSurahes()
            Result.Success(surahList)
        } catch (e: SQLiteException) {
            e.printStackTrace()
            Result.Error(e)
        }
    }

    suspend fun saveAll(surahList: List<Surah>) {
        surahList.forEach {
            surahDao.insert(it.mapToLocal())
        }
    }
}