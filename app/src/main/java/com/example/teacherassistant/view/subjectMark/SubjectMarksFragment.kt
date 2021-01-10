package com.example.teacherassistant.view.subjectMark

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
import com.example.teacherassistant.viewModel.MarkViewModel
import kotlinx.android.synthetic.main.fragment_subject_marks.view.*

class SubjectMarksFragment : Fragment() {

    private val args by navArgs<SubjectMarksFragmentArgs>()

    private lateinit var mMarkViewModel: MarkViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_subject_marks, container, false)

        // Subject name
        view.subjectName.setText(args.currentSubject.nameSubject)

        //Recyclerview
        val adapter = listAdapter()
        val recyclerView = view.subjectMarkRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // MarksMarkViewModel
        mMarkViewModel = ViewModelProvider(this).get(MarkViewModel::class.java)
        mMarkViewModel.readAllData().observe(viewLifecycleOwner, Observer { mark ->
            adapter.setData(mark)
        })

        return view
    }

}

