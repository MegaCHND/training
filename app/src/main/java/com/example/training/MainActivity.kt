package com.example.training

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.training.ui.composeables.MainScreen
import com.example.training.ui.composeables.MainScreen2
import com.example.training.ui.composeables.MainScreen3
import com.example.training.ui.theme.TrainingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Home"){
                composable(route = "Home") {
                    MainScreen(
                        {navController.navigate(route = "Main2")},
                        {navController.navigate(route = "Main3")},
                        )
                }
                composable(route = "Main2") {
                    MainScreen2({navController.navigate(route = "Home")})
                }
                composable(route = "Main3") {
                    MainScreen3()
                }
                activity(route = "asc"){
                    activityClass=SecondActivity::class
                }
            }
        }
    }

    private fun openA2(text:String) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("user_input", text)
        }
        startActivity(intent)
    }
}

