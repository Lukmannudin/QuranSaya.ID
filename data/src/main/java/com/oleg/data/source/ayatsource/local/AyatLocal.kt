package com.oleg.data.source.ayatsource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Crafted by Lukman on 19/02/2022.
 **/

@Entity(tableName = "ayat")
data class AyatLocal(
    @PrimaryKey
    @ColumnInfo(name = "ayat_number")
    val ayatNumber: Int,
    
    @ColumnInfo(name = "translation_text")
    val translationText: String,
    
    @ColumnInfo(name = "arabic_text")
    val arabicText: String,
    
    @ColumnInfo(name = "surah_id")
    val surahId: Int
)