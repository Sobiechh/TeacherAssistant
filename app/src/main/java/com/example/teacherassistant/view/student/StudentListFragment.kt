package com.example.teacherassistant.view.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherassistant.R
import com.example.teacherassistant.viewModel.StudentViewModel
import com.example.teacherassistant.viewModel.SubjectGroupViewModel
import kotlinx.android.synthetic.main.fragment_student_list.view.*

class StudentListFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel
    private lateinit var mSubjectGroupViewModel: SubjectGroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_student_list, container, false)

        //Recyclerview
        val adapter = listAdapter()
        val recyclerView = view.studentRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // SubjectGroupViewModel
        mSubjectGroupViewModel = ViewModelProvider(this).get(SubjectGroupViewModel::class.java)

        // StudentViewModel
        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        mStudentViewModel.readAllData.observe(viewLifecycleOwner, Observer { student ->
            adapter.setVM(mStudentViewModel, mSubjectGroupViewModel)
            adapter.setData(student)
        })

        //button add
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_studentListFragment_to_studentAddFragment)
        }

        return view
    }
}