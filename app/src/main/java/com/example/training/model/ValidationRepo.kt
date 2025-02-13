package com.example.training.model

import kotlinx.coroutines.flow.Flow

//Short demonstration of the Repository Pattern
//Repo's is what we use to expose the Model to the VM
interface ValidationRepo {
    suspend fun validatePhoneNumber(number: String):Flow<Result<ValidationData>>
}