package com.example.todaynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todaynews.R
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
        setContentView(binding.root)
        viewModel.getLiveData().observe(this) { appState -> render(appState) }
        initRecyclerView()
        initChips()
        viewModel.init()
    }

    private fun initChips() {
        binding.newsAppBar.chipsGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.chipAndroid -> {
                    viewModel.getAndroidNews()
                }
                R.id.chipIos -> {
                    viewModel.getIosNews()
                }
                R.id.chipIt -> {
                    viewModel.getItNews()
                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.newsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.newsRecyclerView.adapter = newsAdapter
    }

    private fun render(appState: AppState) {
        when (appState) {
            is AppState.SuccessLoadNews -> {
                newsAdapter.setData(appState.news)
                setLoading(false)
            }
            is AppState.ErrorLoadNews -> {
                setToast(appState.errorMessage)
                setLoading(false)
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