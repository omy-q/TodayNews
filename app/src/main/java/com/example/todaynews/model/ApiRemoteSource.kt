package com.example.todaynews.model

import com.example.todaynews.model.data.NewsData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRemoteSource {

    companion object {
        private const val ANDROID_THEME = "android"
        private const val IOS_THEME = "ios"
        private const val IT_THEME = "it"
        private const val API_KEY = "0950bd626c2840b8b13cd5b9b8bd7643"
    }

    @GET("everything")
    fun getTodayAndroidNews(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("q") theme: String = ANDROID_THEME,
        @Query("from") todayDate: String
    ): Single<NewsData>

    @GET("/everything")
    fun getTodayIosNews(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("q") theme: String = IOS_THEME,
        @Query("from") todayDate: String
    ): Single<NewsData>

    @GET("/everything")
    fun getTodayItNews(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("q") theme: String = IT_THEME,
        @Query("from") todayDate: String
    ): Single<NewsData>
}