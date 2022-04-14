package com.example.todaynews.model.converter

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    fun getTodayDateForApi(): String {
        val converter = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)
        return converter.format(Date())
    }

    fun getDateForView(date: String): String {
        return date.split("T")[0]
    }

}