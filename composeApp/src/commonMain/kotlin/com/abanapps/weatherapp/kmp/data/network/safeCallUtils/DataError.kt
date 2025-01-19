package com.abanapps.weatherapp.kmp.data.network.safeCallUtils


sealed interface DataError:Error {

    enum class Remote:DataError{
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN
    }

}