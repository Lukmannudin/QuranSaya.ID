package com.oleg.quransayaid.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oleg.data.api.ApiHelper
import com.oleg.data.common.AppDatabase
import com.oleg.data.source.surahsource.local.SurahDao
import com.oleg.data.source.surahsource.local.SurahLocalDataSource
import com.oleg.data.source.surahsource.remote.SurahRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Crafted by Lukman on 06/02/22.
 **/

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "quransaya.id"
        ).build()
    }

    @Provides
    fun provideSurahRemoteDataSource(apiHelper: ApiHelper): SurahRemoteDataSource {
        return SurahRemoteDataSource(apiHelper)
    }

    @Provides
    fun provideSurahLocalDataSource(database: AppDatabase): SurahLocalDataSource {
        return SurahLocalDataSource(database.surahDao())
    }
}