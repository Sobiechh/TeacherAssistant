package com.example.teacherassistant.view.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.viewModel.StudentViewModel
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.student_custom_row.view.*

class listAdapter : RecyclerView.Adapter<listAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

    private lateinit var mStudentViewModel: StudentViewModel
    private lateinit var mSubjectGroupViewModel: SubjectGroupViewModel

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.itemView.id_txt.text = currentItem.idStudent.toString()
        holder.itemView.firstName_txt.text = currentItem.nameStudent.toString()
        holder.itemView.lastName_txt.text = currentItem.surnameStudent.toString()

        //edit button click
        holder.itemView.btn_edit.setOnClickListener{
            //navigate with args
            val action = StudentListFragmentDirections.actionStudentListFragmentToStudentUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

        //delete button click
        holder.itemView.btn_del.setOnClickListener {
            mStudentViewModel.deleteStudent(currentItem)
            mSubjectGroupViewModel.deleteEmptyStudentGroup(currentItem.nameStudent.toString(), currentItem.surnameStudent.toString())
        }
    }

    fun setData(student: List<Student>){
        this.studentList = student
        notifyDataSetChanged()
    }

    fun setVM(studentViewModel: StudentViewModel, subjectGroupViewModel: SubjectGroupViewModel){
        this.mStudentViewModel = studentViewModel
        this.mSubjectGroupViewModel = subjectGroupViewModel
    }
}