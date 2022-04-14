package com.example.todaynews.model

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRemoteSource {

    @GET("/everything?q=android")
    fun getAndroidNews(
        @Query("apiKey") apiKey: String,
        @Query("from") todayDate: String
    )

    @GET("/everything?q=ios")
    fun getIosNews(
        @Query("apiKey") apiKey: String,
        @Query("from") todayDate: String
    )

    @GET("/everything?q=it")
    fun getItNews(
        @Query("apiKey") apiKey: String,
        @Query("from") todayDate: String
    )
}