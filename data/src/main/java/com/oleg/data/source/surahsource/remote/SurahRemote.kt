package com.oleg.data.source.surahsource.remote

import com.squareup.moshi.Json

data class SurahRemote(
    @Json(name = "ayah_count")
    val ayahCount: Int? = null,

    @Json(name = "arabic")
    val arabic: String? = null,

    @Json(name = "translation")
    val translation: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "latin")
    val latin: String? = null
)
