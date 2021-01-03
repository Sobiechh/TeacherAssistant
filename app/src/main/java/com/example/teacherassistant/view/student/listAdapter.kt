package com.example.teacherassistant.view.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student.Student
import kotlinx.android.synthetic.main.student_custom_row.view.*

class listAdapter : RecyclerView.Adapter<listAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_custom_row, parent, false))
    }


    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.name.toString()
        holder.itemView.lastName_txt.text = currentItem.surname.toString()
    }

    fun setData(student: List<Student>){
        this.studentList = student
        notifyDataSetChanged()
    }
}