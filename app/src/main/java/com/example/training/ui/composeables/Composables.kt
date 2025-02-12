package com.example.training.ui.composeables

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.training.SecondActivity
import com.example.training.ui.theme.TrainingTheme

@Composable
fun MainScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    rememberSaveable {  }
    TrainingTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(value = text, onValueChange = { newString -> text = newString })
                Button(onClick = { onClick1() }) {
                    Text("Open MainScreen 2")
                }
                Button(onClick = { onClick2() }) {
                    Text("Open MainScreen 3")
                }
            }

        }
    }
}

@Composable
fun MainScreen2(
    onClick: () -> Unit
) {
    var text by remember { mutableStateOf("") }
    TrainingTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(value = text, onValueChange = { newString -> text = newString })
                Button(onClick = { onClick() }) {
                    Text("Open Main screen 1")
                }
            }

        }
    }
}

@Composable
fun MainScreen3() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    TrainingTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(value = text, onValueChange = { newString -> text = newString })
                Button(onClick = {
                    val intent = Intent(context, SecondActivity::class.java).apply {
                        putExtra("user_input", text)
                    }
                    context.startActivity(intent)
                }) {
                    Text("Open SecondActivity")
                }
            }

        }
    }
}

