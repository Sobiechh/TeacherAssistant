package com.example.teacherassistant.view.subjectMark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.SubjectGroup.SubjectGroup
import com.example.teacherassistant.view.subject.listAdapter
import kotlinx.android.synthetic.main.subject_marks_custom_row.view.*

class listAdapter : RecyclerView.Adapter<listAdapter.MyViewHolder>() {

    private var subjectMarksList = emptyList<SubjectGroup>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listAdapter.MyViewHolder {
        return listAdapter.MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_marks_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        subjectMarksList.size
    }

    override fun onBindViewHolder(holder: listAdapter.MyViewHolder, position: Int) {
        val currentItem = subjectMarksList[position]
        holder.itemView.firstName_txt.text = currentItem.studentID.toString()

    }


}