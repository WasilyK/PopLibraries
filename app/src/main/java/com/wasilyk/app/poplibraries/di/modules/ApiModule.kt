package com.wasilyk.app.poplibraries.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wasilyk.app.poplibraries.di.annotations.AppScope
import com.wasilyk.app.poplibraries.di.annotations.BaseUrl
import com.wasilyk.app.poplibraries.model.api.GithubApi
import com.wasilyk.app.poplibraries.model.api.GithubApiInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://api.github.com/"

    @AppScope
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideGithubApi(@BaseUrl baseUrl: String, gson: Gson): GithubApi = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(GithubApiInterceptor)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(GithubApi::class.java)
}