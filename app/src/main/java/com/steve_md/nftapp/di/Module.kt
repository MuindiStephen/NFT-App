/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.di
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.steve_md.nftapp.network.ApiDataSource
import com.steve_md.nftapp.network.NftApiService
import com.steve_md.nftapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module  {

    @Provides
    fun providesNftBaseUrl() = BASE_URL

    @Provides
    fun providesGson() : Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson) : Retrofit {
        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder().also {
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                    it.addInterceptor(httpLoggingInterceptor)
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesNftApiService(retrofit: Retrofit) : NftApiService =
        retrofit.create(NftApiService::class.java)

    @Provides
    @Singleton
    fun providesApiDataSource(apiService: NftApiService) = ApiDataSource(apiService)

}