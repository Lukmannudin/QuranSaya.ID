package com.oleg.data.di

import com.oleg.data.source.ayatsource.AyatRepository
import com.oleg.data.source.ayatsource.AyatRepositoryImpl
import com.oleg.data.source.ayatsource.remote.AyatRemoteDataSource
import com.oleg.data.source.surahsource.SurahRepository
import com.oleg.data.source.surahsource.SurahRepositoryImpl
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
    fun provideSurahRepository(surahDataSource: SurahRemoteDataSource): SurahRepository {
        return SurahRepositoryImpl(surahDataSource)
    }

    @Provides
    fun provideAyatRepository(ayatRemoteDataSource: AyatRemoteDataSource): AyatRepository {
        return AyatRepositoryImpl(ayatRemoteDataSource)
    }
}