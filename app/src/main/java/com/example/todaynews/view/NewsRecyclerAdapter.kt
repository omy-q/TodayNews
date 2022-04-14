package com.example.todaynews.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todaynews.databinding.ItemNewsBinding
import com.example.todaynews.model.data.News

class NewsRecyclerAdapter : RecyclerView.Adapter<NewsRecyclerHolder>() {
    private var data: MutableList<News> = mutableListOf()

    fun setData(data: List<News>) {
        this.data = data.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRecyclerHolder {
        return NewsRecyclerHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsRecyclerHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}