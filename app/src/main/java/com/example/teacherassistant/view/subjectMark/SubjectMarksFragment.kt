package com.example.teacherassistant.view.subjectMark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.R
import kotlinx.android.synthetic.main.fragment_subject_marks.view.*

class SubjectMarksFragment : Fragment() {

    private val args by navArgs<SubjectMarksFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_subject_marks, container, false)

        view.subjectName.setText(args.currentSubject.name)

        return view
    }

}