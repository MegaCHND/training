package com.example.training.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class RecyclerComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items by remember { mutableStateOf(examList) }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items) { item ->
                    ExamCard(item, onclick = { onItemClick(item.examMessage) })
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }

    private fun onItemClick(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}