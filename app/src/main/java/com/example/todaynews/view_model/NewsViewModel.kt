package com.example.todaynews.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todaynews.model.Repository
import com.example.todaynews.model.RepositoryImpl
import com.example.todaynews.model.RetrofitRemoteSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val newsRepository: Repository = RepositoryImpl(RetrofitRemoteSource.retrofitSource)
) : ViewModel() {

    fun getLiveData() = liveData

    fun init(){
        getAndroidNews()
    }

    fun getAndroidNews() {
        val date = "2022-04-14"
        newsRepository.getAndroidNews(date)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newsData ->
                liveData.postValue(AppState.SuccessLoadNews(newsData.news))
            }, { error ->
                liveData.postValue(AppState.ErrorLoadNews(error.message))
            })
    }

    fun getIosNews() {
        val date = "2022-04-14"
        newsRepository.getIosNews(date)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newsData ->
                liveData.postValue(AppState.SuccessLoadNews(newsData.news))
            }, { error ->
                liveData.postValue(AppState.ErrorLoadNews(error.message))
            })
    }

    fun getItNews() {
        val date = "2022-04-14"
        newsRepository.getItNews(date)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newsData ->
                liveData.postValue(AppState.SuccessLoadNews(newsData.news))
            }, { error ->
                liveData.postValue(AppState.ErrorLoadNews(error.message))
            })
    }
}