package com.example.teacherassistant.view.today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Mark.Mark
import com.example.teacherassistant.view.subjectMark.listAdapter
import kotlinx.android.synthetic.main.subject_marks_custom_row.view.*

class listAdapter : RecyclerView.Adapter<listAdapter.MyViewHolder>() {

    private var subjectMarksList = emptyList<Mark>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listAdapter.MyViewHolder {
        return listAdapter.MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_marks_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return subjectMarksList.size
    }

    override fun onBindViewHolder(holder: listAdapter.MyViewHolder, position: Int) {
        val currentItem = subjectMarksList[position]
        holder.itemView.firstName_txt.text = currentItem.student.nameStudent.toString()
        holder.itemView.lastName_txt.text = currentItem.student.surnameStudent.toString()
        holder.itemView.mark_txt.text = currentItem.grade.toString()
        holder.itemView.date_txt.text = currentItem.date.toString()
        holder.itemView.description_txt.text = currentItem.note.toString()
    }

    fun setData(mark:  List<Mark>){
        this.subjectMarksList = mark
        notifyDataSetChanged()
    }
}