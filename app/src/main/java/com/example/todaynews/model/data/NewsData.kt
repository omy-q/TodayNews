package com.example.todaynews.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsData(
    @Expose
    @SerializedName("articles")
    val news: List<News>
)

