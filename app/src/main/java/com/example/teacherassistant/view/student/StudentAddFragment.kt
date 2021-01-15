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
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import com.example.teacherassistant.model.SubjectGroup.SubjectGroup
import com.example.teacherassistant.viewModel.StudentViewModel
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.fragment_student_add.*
import kotlinx.android.synthetic.main.fragment_student_add.view.*

class StudentAddFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel
    private lateinit var  mSubjectGroupViewModel: SubjectGroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_add, container, false)

        // StudentViewModel
        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        // SubjectGroupViewModel
        mSubjectGroupViewModel = ViewModelProvider(this).get(SubjectGroupViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = Name.text.toString()
        val lastName = Surname.text.toString()

        if(inputCheck(firstName, lastName)){
            val student = Student(0, firstName, lastName)
            // Add to database
            mStudentViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Succesfully added!", Toast.LENGTH_LONG).show()

            // Add to subjectGroup
            val subjectGroup = SubjectGroup(0, student, Subject(1000, "A"))
            mSubjectGroupViewModel.addSubjectGroup(subjectGroup)

            //Navigate Back
            findNavController().navigate(R.id.action_studentAddFragment_to_studentListFragment)
        }
        else{
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && !(TextUtils.isEmpty(lastName)))
    }

}