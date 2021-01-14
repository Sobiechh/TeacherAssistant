package com.example.teacherassistant.view.studentInSubject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import com.example.teacherassistant.model.SubjectGroup.SubjectGroup
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.add_student_subject_custom_row.view.*

class listAdapterAddStudent : RecyclerView.Adapter<listAdapter.MyViewHolder>() {

    private var subjectGroupList = emptyList<SubjectGroup>()

    private var arguments = emptyArray<String>()

    private lateinit var mSubjectGroupViewModel: SubjectGroupViewModel

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listAdapter.MyViewHolder {
        return listAdapter.MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.add_student_subject_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return subjectGroupList.size
    }

    override fun onBindViewHolder(holder: listAdapter.MyViewHolder, position: Int) {

        val currentItem = subjectGroupList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.student.nameStudent.toString()
        holder.itemView.lastName_txt.text = currentItem.student.surnameStudent.toString()

        //add button click
        holder.itemView.btn_add.setOnClickListener{
            val idStudent = currentItem.student.idStudent
            val firstName = currentItem.student.nameStudent.toString()
            val lastName = currentItem.student.surnameStudent.toString()
            val idSubject = arguments[0]
            val nameSubject = arguments[1]

            val subjectGroup = SubjectGroup(0, Student(idStudent, firstName, lastName), Subject(idSubject.toInt(), nameSubject))
            // Add to database
            mSubjectGroupViewModel.addSubjectGroup(subjectGroup)
        }

    }

    fun setData(subjectGrup: List<SubjectGroup>){
        this.subjectGroupList = subjectGrup
        notifyDataSetChanged()
    }

    fun setArgs(arguments: Array<String>) {
        this.arguments = arguments
    }

    fun setVM(subjectGroupViewModel: SubjectGroupViewModel){
        this.mSubjectGroupViewModel = subjectGroupViewModel
    }
}