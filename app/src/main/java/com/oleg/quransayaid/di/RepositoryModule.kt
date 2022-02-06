package com.oleg.quransayaid.di

import com.oleg.quransayaid.data.surahsource.SurahDataSource
import com.oleg.quransayaid.data.surahsource.SurahRepository
import com.oleg.quransayaid.data.surahsource.SurahRepositoryImpl
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
    fun provideSurahRepository(surahDataSource: SurahDataSource): SurahRepository {
        return SurahRepositoryImpl(surahDataSource)
    }
}