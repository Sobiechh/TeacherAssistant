package com.example.teacherassistant.view.studentInSubject

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Mark.Mark
import com.example.teacherassistant.viewModel.MarkViewModel
import kotlinx.android.synthetic.main.fragment_add_mark.*
import kotlinx.android.synthetic.main.fragment_add_mark.view.*
import java.util.*


class AddMarkFragment : Fragment() {

    private val args by navArgs<AddMarkFragmentArgs>()

    private  lateinit var mMarkViewModel: MarkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_mark, container, false)

        // MarksMarkViewModel
        mMarkViewModel = ViewModelProvider(this).get(MarkViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val Mark = Mark.text.toString()
        val Note = Note.text.toString()

        if(inputCheck(Mark, Note)){
            val mark = Mark(0,args.currentSubjectStudent.student, args.currentSubjectStudent.subject, Note, Mark.toDouble(), Date(System.currentTimeMillis()))
            //Add to database
            mMarkViewModel.addMark(mark)
            Toast.makeText(requireContext(), "Succesfully added!", Toast.LENGTH_LONG).show()
            //Navigate Back
//            findNavController().navigate(R.id.action_addMarkFragment_to_studentsInSubjectFragment)
        }
        else{
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(Mark: String, Note: String): Boolean{
        return !(TextUtils.isEmpty(Mark) && !(TextUtils.isEmpty(Note)))
    }
}