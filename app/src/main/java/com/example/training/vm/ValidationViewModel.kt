package com.example.training.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.training.model.Result
import com.example.training.model.ValidationData
import com.example.training.model.ValidationRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The VM, the brains of the app
 * All business logic is placed here
 * Though not shown in this example, through the use of interfaces, we can easily create test cases
 * for this VM's functions
 * */
@HiltViewModel
class ValidationViewModel @Inject constructor(
    private val validationRepo: ValidationRepo
) : ViewModel() {
    /**
     * Different projects will have different ways to expose data to the View
     * These are just 2 examples
     * */
    private val _validationData = MutableStateFlow<Result<ValidationData>>(Result.Loading())
    val validationData = _validationData.asStateFlow()

    /**
     * personally, I like this second method more.
     * You will notice in the ValidationScreen, I have to collect validationData with .collectAsState()
     * With this second method number is already a state
     * and the private set protects me from accidentally changing it directly on the ui
     * */
    var number by mutableStateOf("")
        private set

    fun updateNumber(newNumber: String) {
        number = newNumber
    }

    fun onValidateClick() {
        viewModelScope.launch(Dispatchers.IO) {
            validationRepo.validatePhoneNumber(number).collectLatest { result ->
                _validationData.update { result }
            }
        }
    }
}