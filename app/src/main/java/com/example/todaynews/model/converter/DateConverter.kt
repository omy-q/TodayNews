package com.example.todaynews.model.converter

import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    fun getTodayDateForApi(): String {
        val converter = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)
        return converter.format(Date())
    }
}