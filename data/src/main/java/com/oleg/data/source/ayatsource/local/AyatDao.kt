package com.oleg.data.source.ayatsource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Crafted by Lukman on 19/02/2022.
 **/
@Dao
interface AyatDao {
    
    @Query("SELECT * FROM ayat WHERE surah_id =:id")
    suspend fun getAll(id: Int): List<AyatLocal>
    
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(ayatLocal: AyatLocal)
    
}