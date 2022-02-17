package com.oleg.data

import android.util.Base64

/**
 * Crafted by Lukman on 17/01/22.
 **/

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    private external fun getBaseUrlToken(): String

    fun getBaseUrl() = getDecodedString(getBaseUrlToken())

    private fun getDecodedString(key: String): String {
        return String(Base64.decode(key, Base64.DEFAULT), Charsets.UTF_8)
    }
}