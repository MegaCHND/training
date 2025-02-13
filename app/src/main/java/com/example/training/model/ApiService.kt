package com.example.training.model

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This interface is for retrofit.
 * It tells retrofit what calls to make and which data class to translate the response JSON into
 */
interface ApiService {

    @GET("${BASE_URL}validate")
    suspend fun validatePhoneNumber(
        @Query("number") number: String,
        @Query("access_key") key: String = API_KEY
    ): ValidationData

    companion object {
        const val BASE_URL = "https://apilayer.net/api/"
        const val API_KEY = "809f088f70491e6d13a68215a0f51947"
    }
}