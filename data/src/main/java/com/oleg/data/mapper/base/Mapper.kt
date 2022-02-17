package com.oleg.data.mapper.base

/**
 * Crafted by Lukman on 07/02/22.
 **/

interface Mapper<I, O> {
    fun map(input: I): O
}