package com.infinite.tugaskotlinadvance.pages.fetchapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkInstance {
    companion object {
        private const val BASE_URL = "https://652cff5ff9afa8ef4b26971c.mockapi.io/api/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val apiService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}