package com.example.todaynews.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todaynews.model.Repository
import com.example.todaynews.model.RepositoryImpl
import com.example.todaynews.model.RetrofitRemoteSource
import com.example.todaynews.model.converter.DateConverter
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
        liveData.value = AppState.Loading
        newsRepository.getAndroidNews(DateConverter.getTodayDateForApi())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newsData ->
                liveData.postValue(AppState.SuccessLoadNews(newsData.news))
            }, { error ->
                liveData.postValue(AppState.ErrorLoadNews(error.message))
            })
    }

    fun getIosNews() {
        liveData.value = AppState.Loading
        newsRepository.getIosNews(DateConverter.getTodayDateForApi())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newsData ->
                liveData.postValue(AppState.SuccessLoadNews(newsData.news))
            }, { error ->
                liveData.postValue(AppState.ErrorLoadNews(error.message))
            })
    }

    fun getItNews() {
        liveData.value = AppState.Loading
        newsRepository.getItNews(DateConverter.getTodayDateForApi())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ newsData ->
                liveData.postValue(AppState.SuccessLoadNews(newsData.news))
            }, { error ->
                liveData.postValue(AppState.ErrorLoadNews(error.message))
            })
    }
}