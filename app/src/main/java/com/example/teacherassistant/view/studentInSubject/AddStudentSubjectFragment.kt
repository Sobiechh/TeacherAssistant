package com.example.teacherassistant.view.studentInSubject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.fragment_add_student_subject.view.*


class AddStudentSubjectFragment : Fragment() {

    private lateinit var mSubjectGroupViewModel: SubjectGroupViewModel

    private val args by navArgs<AddStudentSubjectFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_student_subject, container, false)

        mSubjectGroupViewModel = ViewModelProvider(this).get(SubjectGroupViewModel::class.java)

        val adapter = listAdapterAddStudent()
        val recyclerView = view.addStudentSubjectRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // SubjectGroupViewModel
        mSubjectGroupViewModel = ViewModelProvider(this).get(SubjectGroupViewModel::class.java)
        // Get students not in course
        mSubjectGroupViewModel.getStudentsNotInSubject(args.currentSubject.idSubject.toInt()).observe(viewLifecycleOwner, Observer { addStudent ->
            adapter.setArgs(arrayOf(args.currentSubject.idSubject.toString(), args.currentSubject.nameSubject.toString()))
            adapter.setVM(mSubjectGroupViewModel)
            adapter.setData(addStudent)
        })

        return view
    }

}