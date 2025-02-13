package com.example.training.model

import com.google.gson.annotations.SerializedName

//Data class for the api response
data class ValidationData(
    val valid: Boolean,
    @SerializedName("local_format")
    val localFormat: String,
    @SerializedName("international_format")
    val intlFormat: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_name")
    val countryName: String,
    val location: String,
    val carrier: String,
    @SerializedName("line_type")
    val lineType: String
)

//Sealed class to hold api states
sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Result<T>(data)
    class Loading<T>: Result<T>()
    class Error<T>(data: T? = null, message: String) : Result<T>(data, message)
}