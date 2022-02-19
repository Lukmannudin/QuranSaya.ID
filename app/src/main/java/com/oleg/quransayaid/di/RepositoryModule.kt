package com.oleg.quransayaid.di

import com.oleg.data.source.ayatsource.AyatRepository
import com.oleg.data.source.ayatsource.AyatRepositoryImpl
import com.oleg.data.source.ayatsource.local.AyatLocalDataSource
import com.oleg.data.source.ayatsource.remote.AyatRemoteDataSource
import com.oleg.data.source.surahsource.SurahRepository
import com.oleg.data.source.surahsource.SurahRepositoryImpl
import com.oleg.data.source.surahsource.local.SurahLocalDataSource
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
object RepositoryModule {

    @Provides
    fun provideSurahRepository(
        surahRemoteDataSource: SurahRemoteDataSource,
        surahLocalDataSource: SurahLocalDataSource
    ): SurahRepository {
        return SurahRepositoryImpl(surahRemoteDataSource, surahLocalDataSource)
    }

    @Provides
    fun provideAyatRepository(
        ayatRemoteDataSource: AyatRemoteDataSource,
        ayatLocalDataSource: AyatLocalDataSource
    ): AyatRepository {
        return AyatRepositoryImpl(ayatRemoteDataSource, ayatLocalDataSource)
    }
}