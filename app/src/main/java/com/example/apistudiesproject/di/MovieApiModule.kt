package com.example.apistudiesproject.di

import com.example.apistudiesproject.ApiConstant.BASE_URL
import com.example.apistudiesproject.network.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieApiModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): MovieApiService {
        return builder
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}

