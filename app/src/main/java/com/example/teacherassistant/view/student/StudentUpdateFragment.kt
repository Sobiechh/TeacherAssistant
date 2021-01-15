package com.example.teacherassistant.view.student

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.viewModel.StudentViewModel
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.fragment_student_update.*
import kotlinx.android.synthetic.main.fragment_student_update.view.*

class StudentUpdateFragment : Fragment() {

    private val args by navArgs<StudentUpdateFragmentArgs>()

    private lateinit var mStudentViewModel: StudentViewModel
    private lateinit var mSubjectGroupViewModel: SubjectGroupViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_student_update, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        mSubjectGroupViewModel = ViewModelProvider(this).get(SubjectGroupViewModel::class.java)

        view.updateFirstName_et.setText(args.currentStudent.nameStudent)
        view.updateLastName_et.setText(args.currentStudent.surnameStudent)

        view.update_btn.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem(){
        val firstName = updateFirstName_et.text.toString()
        val lastName = updateLastName_et.text.toString()

        if(inputCheck(firstName, lastName)){
            //Create Student Object
            val updatedStudent = Student(args.currentStudent.idStudent, firstName, lastName)
            // Update Current Student
            mStudentViewModel.updateStudent(updatedStudent)
            Toast.makeText(requireContext(), "Updated successfully!", Toast.LENGTH_SHORT).show()

            // Update Subject Group
            mSubjectGroupViewModel.updateStudentNameInStudentGrup(args.currentStudent.nameStudent.toString(), args.currentStudent.surnameStudent.toString(), firstName, lastName)

            //Navigate back
            findNavController().navigate(R.id.action_studentUpdateFragment_to_studentListFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && !(TextUtils.isEmpty(lastName)))
    }
    
}