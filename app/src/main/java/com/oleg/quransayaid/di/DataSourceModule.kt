package com.oleg.quransayaid.di

import com.oleg.quransayaid.api.ApiHelper
import com.oleg.quransayaid.data.surahsource.SurahDataSource
import com.oleg.quransayaid.data.surahsource.remote.SurahRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Crafted by Lukman on 06/02/22.
 **/

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideSurahRemoteDataSource(apiHelper: ApiHelper): SurahDataSource {
        return SurahRemoteDataSource(apiHelper)
    }
}