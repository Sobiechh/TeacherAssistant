package com.example.teacherassistant.view.studentInSubject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.fragment_students_in_subject.view.*

class StudentsInSubjectFragment : Fragment() {

    private val args by navArgs<StudentsInSubjectFragmentArgs>()

    private lateinit var mSubjectGroupViewModel: SubjectGroupViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_students_in_subject, container, false)

        // Subject name
        view.subjectName.setText(args.currentSubject.nameSubject.toString())

        view.addStudent.setOnClickListener {
            //navigate with args
            val action = StudentsInSubjectFragmentDirections.actionStudentsInSubjectFragmentToAddStudentSubject(args.currentSubject)
            findNavController().navigate(action)
        }

        // Recyclerview
        val adapter = listAdapter()
        val recyclerView = view.studentInSubjectRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // SubjectGroupViewModel
        mSubjectGroupViewModel = ViewModelProvider(this).get(SubjectGroupViewModel::class.java)
        mSubjectGroupViewModel.getSubjectStudents(args.currentSubject.idSubject.toInt()).observe(viewLifecycleOwner, Observer { student ->
            adapter.setData(student)
        })


        return view
    }

}