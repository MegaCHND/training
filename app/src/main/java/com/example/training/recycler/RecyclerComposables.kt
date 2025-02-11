package com.example.training.recycler

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun ExamCard(exam: ExamItem, onclick: () ->Unit){
    Column(modifier = Modifier.clickable { onclick() }) {
        Text(exam.examName)
        Text(exam.examDate)
        Text(exam.examMessage)
        AsyncImage(model = exam.examPic, contentDescription = null)
    }
}