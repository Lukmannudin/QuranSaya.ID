package com.oleg.data.source.surahsource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Crafted by Lukman on 17/02/22.
 **/

@Entity(tableName = "surah")
data class SurahLocal(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "latin")
    val latin: String,

    @ColumnInfo(name = "translation")
    val translation: String,

    @ColumnInfo(name = "arabic")
    val arabic: String,

    @ColumnInfo(name = "ayat_count")
    val ayatCount: Int
)