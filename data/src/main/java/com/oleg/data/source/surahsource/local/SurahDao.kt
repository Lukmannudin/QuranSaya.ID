package com.oleg.data.source.surahsource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Crafted by Lukman on 17/02/22.
 **/

@Dao
interface SurahDao {

    @Query("SELECT * FROM surah")
    suspend fun getAll(): List<SurahLocal>

    @Insert
    suspend fun insert(surahLocal: SurahLocal)

}