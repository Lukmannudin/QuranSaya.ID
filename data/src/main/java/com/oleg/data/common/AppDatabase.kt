package com.oleg.data.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oleg.data.source.surahsource.local.SurahDao
import com.oleg.data.source.surahsource.local.SurahLocal

/**
 * Crafted by Lukman on 17/02/22.
 **/

@Database(entities = [SurahLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun surahDao(): SurahDao

}