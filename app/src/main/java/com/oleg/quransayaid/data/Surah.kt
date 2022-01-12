package com.oleg.quransayaid.data

/**
 * Crafted by Lukman on 12/01/22.
 **/

data class Surah(
    val id: Int,
    val latin: String,
    val translation: String,
    val arabic: String,
    val ayatCount: Int
)