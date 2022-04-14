package com.example.todaynews.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(
    @Expose
    @SerializedName("name")
    val name: String
)
data class News(
    @Expose
    @SerializedName("source")
    val source: Source,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("urlToImage")
    val imageUrl: String,
    @Expose
    @SerializedName("publishedAt")
    val publishedDate: String
)
