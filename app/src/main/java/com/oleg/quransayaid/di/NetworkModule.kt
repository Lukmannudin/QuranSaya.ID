package com.oleg.quransayaid.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.oleg.quransayaid.BuildConfig
import com.oleg.quransayaid.api.ApiHelper
import com.oleg.quransayaid.api.ApiHelperImpl
import com.oleg.quransayaid.api.ApiService
import com.oleg.quransayaid.common.Keys
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Crafted by Lukman on 12/01/22.
 **/

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @ApplicationContext context: Context
    ) = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    } else {
        OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshiBuilder() =
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(Keys.getBaseUrl())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideHelper(apiService: ApiService): ApiHelper = ApiHelperImpl(apiService)
}