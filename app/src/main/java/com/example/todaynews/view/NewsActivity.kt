package com.example.todaynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todaynews.databinding.ActivityNewsBinding
import com.example.todaynews.view_model.AppState
import com.example.todaynews.view_model.NewsViewModel

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }
    private val newsAdapter = NewsRecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        viewModel.getLiveData().observe(this) { appState ->
            render(appState)
        }
        initRecyclerView()
        setContentView(binding.root)
    }

    private fun initRecyclerView() {
        binding.newsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.newsRecyclerView.adapter = newsAdapter
    }

    private fun render(appState: AppState) {
        when (appState) {
            is AppState.SuccessLoadNews -> {
                setLoading(false)
                newsAdapter.setData(appState.news)
            }
            is AppState.ErrorLoadNews -> {
                setLoading(false)
                setToast(appState.errorMessage)
            }
            is AppState.Loading -> {
                setLoading(true)
            }
        }
    }

    private fun setToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setLoading(isVisible: Boolean) {
        with(binding.loading) {
            visibility = if (isVisible) View.VISIBLE
            else View.GONE
        }
    }
}