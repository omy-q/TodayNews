package com.example.todaynews.model

import com.example.todaynews.model.data.NewsData
import io.reactivex.rxjava3.core.Single

class RepositoryImpl(
    private val remoteSource: ApiRemoteSource
) : Repository {

    override fun getAndroidNews(date: String): Single<NewsData> {
        return remoteSource.getTodayAndroidNews(date)
    }

    override fun getIosNews(date: String): Single<NewsData> {
        return remoteSource.getTodayIosNews(date)
    }

    override fun getItNews(date: String): Single<NewsData> {
        return remoteSource.getTodayItNews(date)
    }
}