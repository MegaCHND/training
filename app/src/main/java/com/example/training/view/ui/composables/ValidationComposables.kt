package com.example.training.view.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.training.model.Result
import com.example.training.model.ValidationData
import com.example.training.view.ui.theme.TrainingTheme
import com.example.training.vm.ValidationViewModel

@Composable
fun ValidationScreen() {
    val vm = hiltViewModel<ValidationViewModel>()
    val vData = vm.validationData.collectAsState()
    val number = vm.number
    TrainingTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(value = number, onValueChange = vm::updateNumber)
                Button(onClick = vm::onValidateClick) {
                    Text("Validate this Number")
                }
                when (vData.value) {
                    is Result.Error -> vData.value.message?.let{FailedSection(message = it)}
                    is Result.Loading -> LoadingSection()
                    is Result.Success -> vData.value.data?.let{SuccessSection(it)}
                }
            }
        }
    }
}

@Composable
fun SuccessSection(data: ValidationData) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Valid ${data.valid}")
        Text("Local Format ${data.localFormat}")
        Text("Intl. Format ${data.intlFormat}")
        Text("Country ${data.countryName}")
        Text("Location ${data.location}")
        Text("Carrier ${data.carrier}")
        Text("Line Type ${data.lineType}")
    }
}


@Composable
fun FailedSection(message: String) {
    Text(message)
}


@Composable
fun LoadingSection() {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}