package com.example.todaynews.view

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.todaynews.databinding.ItemNewsBinding
import com.example.todaynews.model.data.News

class NewsRecyclerHolder(private val binding: ItemNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: News) {
        binding.newsSource.text = data.source.name
        binding.newsPublishedDate.text = data.date
        binding.newsImage.load(data.imageUrl)
        binding.newsTitle.text = data.title
        binding.newsDescription.text = data.description
    }
}