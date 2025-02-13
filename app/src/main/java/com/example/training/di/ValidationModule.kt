package com.example.training.di

import com.example.training.model.ApiService
import com.example.training.model.ValidationRepo
import com.example.training.model.ValidationRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * After you create your model layer, you should create this Module for DI
 * https://developer.android.com/training/dependency-injection/hilt-android
 * */
@Module
@InstallIn(SingletonComponent::class)
object ValidationModule {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesApiService():ApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiService.BASE_URL)
        .client(client)
        .build()
        .create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesValidationRepo(apiService: ApiService): ValidationRepo =
        ValidationRepoImpl(apiService)
}