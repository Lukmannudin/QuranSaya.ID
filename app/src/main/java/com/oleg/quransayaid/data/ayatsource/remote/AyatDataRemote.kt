package com.oleg.quransayaid.data.ayatsource.remote

import com.squareup.moshi.Json


data class AyatDataRemote(

    @Json(name = "number_of_ayat")
    val numberOfAyat: Int? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "translation_name")
    val translationName: String? = null,

    @Json(name = "list_ayat")
    val listAyatRemote: List<AyatRemote>? = null,

    @Json(name = "name_latin")
    val nameLatin: String? = null
)
