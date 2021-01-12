package com.example.teacherassistant.view.studentInSubject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.SubjectGroup.SubjectGroup
import kotlinx.android.synthetic.main.subject_students_custom_row.view.*

class listAdapter : RecyclerView.Adapter<listAdapter.MyViewHolder>()  {

    private var subjectGroupList = emptyList<SubjectGroup>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_students_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return subjectGroupList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = subjectGroupList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.student.nameStudent.toString()
        holder.itemView.lastName_txt.text = currentItem.student.surnameStudent.toString()

        //edit button click
        holder.itemView.btn_mark.setOnClickListener{
            TODO("DO ADD MARK")
        }

        // on subject click
        holder.itemView.btn_del.setOnClickListener {
            TODO("DEL FROM SUBJECTGROUP")
        }
    }

    fun setData(subjectGrup: List<SubjectGroup>){
        this.subjectGroupList = subjectGrup
        notifyDataSetChanged()
    }
}