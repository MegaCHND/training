package com.example.training.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//Implementation of the repo
//We make repos as interfaces so we can swap between production implementation and test implementation
class ValidationRepoImpl @Inject constructor(private val apiService: ApiService) : ValidationRepo {
    override suspend fun validatePhoneNumber(number: String): Flow<Result<ValidationData>> = flow {
        emit(Result.Loading())
        try {
            val data = apiService.validatePhoneNumber(number)
            emit(Result.Success(data))
        } catch (e: Exception) {
            emit(Result.Error(message = e.message.toString()))
        }
    }
}