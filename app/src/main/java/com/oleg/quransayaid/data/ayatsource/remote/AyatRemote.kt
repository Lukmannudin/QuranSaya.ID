package com.oleg.quransayaid.data.ayatsource.remote

import com.squareup.moshi.Json

/**
 * Crafted by Lukman on 08/02/22.
 **/

data class AyatRemote(

    @Json(name = "ayat_number")
    val ayatNumber: Int? = null,

    @Json(name = "translation_text")
    val translationText: String? = null,

    @Json(name = "arabic_text")
    val arabicText: String? = null
)