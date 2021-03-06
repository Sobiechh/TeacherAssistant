package com.example.teacherassistant.view.subject

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
import com.example.teacherassistant.viewModel.SubjectViewModel
import kotlinx.android.synthetic.main.fragment_subject_list.view.*

class SubjectListFragment : Fragment() {

    private lateinit var mSubjectViewModel: SubjectViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_subject_list, container, false)

        //Recyclerview
        val adapter = listAdapter()
        val recyclerView = view.subjectRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //SubjectViewModel
        mSubjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)
        mSubjectViewModel.readAllData.observe(viewLifecycleOwner, Observer { subject ->
            adapter.setData(subject)
        })

        //button add
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_subjectListFragment_to_subjectAddFragment)
        }

        return view
    }
}