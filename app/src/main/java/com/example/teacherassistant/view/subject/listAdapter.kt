package com.example.teacherassistant.view.subject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Subject.Subject
import kotlinx.android.synthetic.main.subject_custom_row.view.*

class listAdapter : RecyclerView.Adapter<listAdapter.MyViewHolder>()  {

    private var subjectList = emptyList<Subject>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.subject_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = subjectList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.lessonName_txt.text = currentItem.name.toString()

        //edit button click
        holder.itemView.btn_edit.setOnClickListener{
            //navigate with args
            val action = SubjectListFragmentDirections.actionSubjectListFragmentToSubjectUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

        // on subject click
        holder.itemView.subjectRowLayout.setOnClickListener {
            //navigate with args
            val action = SubjectListFragmentDirections.actionSubjectListFragmentToSubjectMarksFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(subject: List<Subject>){
        this.subjectList = subject
        notifyDataSetChanged()
    }
}