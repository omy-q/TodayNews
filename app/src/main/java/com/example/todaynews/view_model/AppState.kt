package com.example.todaynews.view_model

import com.example.todaynews.model.data.News

sealed class AppState{
    data class SuccessLoadNews(val news: List<News>): AppState()
    data class ErrorLoadNews(val errorMessage: String?): AppState()
    object Loading : AppState()
}
