package com.example.todaynews.model

import com.example.todaynews.model.data.NewsData
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getAndroidNews(date: String): Single<NewsData>
    fun getIosNews(date: String): Single<NewsData>
    fun getItNews(date: String): Single<NewsData>
}