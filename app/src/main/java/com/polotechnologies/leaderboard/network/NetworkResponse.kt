package com.polotechnologies.leaderboard.network

sealed class NetworkResponse<T> {
    class Loading<T> : NetworkResponse<T>()
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Failed<T>(val exception: Exception) : NetworkResponse<T>()

    companion object {

        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(exception: Exception) = Failed<T>(exception)
    }
}