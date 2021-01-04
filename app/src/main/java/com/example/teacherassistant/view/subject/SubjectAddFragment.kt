package com.example.teacherassistant.view.subject

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
import com.example.teacherassistant.model.Subject.Subject
import com.example.teacherassistant.viewModel.SubjectViewModel
import kotlinx.android.synthetic.main.fragment_subject_add.*
import kotlinx.android.synthetic.main.fragment_subject_add.view.*

class SubjectAddFragment : Fragment() {

    private lateinit var mSubjectViewModel: SubjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_subject_add, container, false)

        mSubjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = Name.text.toString()

        if(inputCheck(name)){
            val subject = Subject(0, name)
            //Add to database
            mSubjectViewModel.addSubject(subject)
            Toast.makeText(requireContext(), "Succesfully added!", Toast.LENGTH_LONG).show()
            //Navigate Back
            findNavController().navigate(R.id.action_subjectAddFragment_to_subjectListFragment)
        }
        else{
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String): Boolean{
        return !(TextUtils.isEmpty(name))
    }
}