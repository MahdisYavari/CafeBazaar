package com.example.interview.tools.di

import com.example.interview.tools.network.api.MovieApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjMmYyMmFlYjc0MjM1NzUzOGI3MTNkM2U4Yjk0MzI4ZCIsInN1YiI6IjY1ZGM4NTRiYjdiNjlkMDE3ZGM5NmQ2NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.C8bGbW2in7sb8Ir3-AZe-JakZi_-XDC5LAJcDFqqMkQ"

    @Provides
    @Singleton
    fun provideRetrofit(headers: Headers): Retrofit {

        val client = OkHttpClient.Builder()
        client.interceptors().add(
            Interceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                    .headers(headers)
                    .method(request.method(), request.body())
                chain.proceed(requestBuilder.build())
            }
        )

        client.readTimeout(30, TimeUnit.SECONDS)
        //log request and response
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        client.addInterceptor(logging)

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideSharedHeaders(): Headers {
        return Headers.Builder()
            .add("accept", "application/json")
            .add("Authorization", "Bearer $apiKey")
            .build()
    }

    @Provides
    @Singleton
    fun provideProductApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}