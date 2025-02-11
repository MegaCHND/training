package com.example.training.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.training.R

class RecyclerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(examList)
        adapter.setOnClickListener(object :
            RecyclerAdapter.OnClickListener {
            override fun onClick(model: ExamItem) {
                Toast.makeText(this@RecyclerActivity, model.examMessage, Toast.LENGTH_SHORT).show()
            }
        }
        )
        recyclerView.adapter = adapter
    }
}