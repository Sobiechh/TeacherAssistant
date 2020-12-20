package com.example.teacherassistant.view.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fragment_list_student.view.*


class ListStudentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_student,  container, false)

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listStudentFragment_to_addStudentFragment)
        }

        return view
    }

}