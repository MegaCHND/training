package com.example.training.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.training.R

class RecyclerAdapter(private val examList: List<ExamItem>) :
    RecyclerView.Adapter<RecyclerAdapter.ExamViewHolder>() {
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exam_card, parent, false)
        return ExamViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        val exam = examList[position]
        holder.examName.text = exam.examName
        holder.examDate.text = exam.examDate
        holder.examMessage.text = exam.examMessage
        Glide.with(holder.itemView).load(exam.examPic).into(holder.examPic)
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(exam)
        }
    }

    override fun getItemCount() = examList.size

    // Set the click listener for the adapter
    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    // Interface for the click listener
    interface OnClickListener {
        fun onClick(model: ExamItem)
    }

    // ViewHolder class
    class ExamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val examName: TextView = itemView.findViewById(R.id.examName)
        val examDate: TextView = itemView.findViewById(R.id.examDate)
        val examMessage: TextView = itemView.findViewById(R.id.examMessage)
        val examPic: ImageView = itemView.findViewById(R.id.examPic)
        val examPic2: ImageView = itemView.findViewById(R.id.examPic2)
    }
}