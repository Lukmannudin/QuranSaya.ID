package com.oleg.data.di

import com.oleg.data.api.ApiHelper
import com.oleg.data.source.surahsource.SurahDataSource
import com.oleg.data.source.surahsource.remote.SurahRemoteDataSource
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