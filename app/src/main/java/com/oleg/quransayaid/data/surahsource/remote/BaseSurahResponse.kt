package com.oleg.quransayaid.data.surahsource.remote

import com.squareup.moshi.Json

/**
 * Crafted by Lukman on 06/02/22.
 **/

data class BaseSurahResponse<T>(

    @Json(name = "data")
    val data: List<T?>? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "status")
    val status: Boolean? = null
)