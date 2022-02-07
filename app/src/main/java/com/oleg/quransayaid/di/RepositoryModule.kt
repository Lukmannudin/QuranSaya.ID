package com.oleg.quransayaid.di

import com.oleg.quransayaid.data.ayatsource.AyatRepository
import com.oleg.quransayaid.data.ayatsource.AyatRepositoryImpl
import com.oleg.quransayaid.data.ayatsource.remote.AyatRemoteDataSource
import com.oleg.quransayaid.data.surahsource.SurahRepository
import com.oleg.quransayaid.data.surahsource.SurahRepositoryImpl
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