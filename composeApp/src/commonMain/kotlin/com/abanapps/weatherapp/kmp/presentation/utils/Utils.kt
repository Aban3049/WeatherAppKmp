package com.abanapps.weatherapp.kmp.presentation.utils

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

object Utils {

    fun convertLongToDateString(timestamp: Long): String {
        val instant = Instant.fromEpochMilliseconds(timestamp)
        val datetime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return datetime.toString()
    }

}