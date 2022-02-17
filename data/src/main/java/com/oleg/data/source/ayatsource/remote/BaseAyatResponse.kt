package com.oleg.data.source.ayatsource.remote

import com.squareup.moshi.Json

/**
 * Crafted by Lukman on 08/02/22.
 **/

data class BaseAyatResponse<T>(

    @Json(name = "data")
    val data: T? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "status")
    val status: Boolean? = null
)