package com.oleg.data.source.ayatsource.local

import android.database.sqlite.SQLiteException
import com.oleg.data.common.Result
import com.oleg.data.domain.Ayat
import com.oleg.data.mapper.ayatmapper.AyatMapper.mapLocalListToAyatList
import com.oleg.data.mapper.ayatmapper.AyatMapper.mapToLocal
import javax.inject.Inject

/**
 * Crafted by Lukman on 19/02/2022.
 **/
class AyatLocalDataSource @Inject constructor(
    private val ayatDao: AyatDao
) {
    
    suspend fun fetchAyatList(surahId: Int): Result<List<Ayat>> {
        return try {
            val ayatList = ayatDao.getAll(surahId).mapLocalListToAyatList()
            Result.Success(ayatList)
        } catch (e: SQLiteException) {
            e.printStackTrace()
            Result.Error(e)
        }
    }
    
    suspend fun saveAll(surahId: Int, ayatList: List<Ayat>) {
        ayatList.forEach { ayat ->
            ayatDao.insert(ayat.mapToLocal(surahId))
        }
    }
}