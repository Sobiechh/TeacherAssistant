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
import androidx.navigation.fragment.navArgs
import com.example.teacherassistant.R
import com.example.teacherassistant.model.Subject.Subject
import com.example.teacherassistant.viewModel.SubjectViewModel
import kotlinx.android.synthetic.main.fragment_subject_update.*
import kotlinx.android.synthetic.main.fragment_subject_update.view.*

class SubjectUpdateFragment : Fragment() {

    private val args by navArgs<SubjectUpdateFragmentArgs>()

    private lateinit var mSubjectViewModel: SubjectViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_subject_update, container, false)

        mSubjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        // Args
        view.updateName_et.setText(args.currentSubject.nameSubject)

        view.update_btn.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem() {
        val name = updateName_et.text.toString()

        if(inputCheck(name)){
            // Create Subject Object
            val updatedSubject = Subject(args.currentSubject.idSubject, name)
            // Update Current Subject
            mSubjectViewModel.updateSubject(updatedSubject)
            Toast.makeText(requireContext(), "Updated successfully!", Toast.LENGTH_SHORT).show()
            // Navigate back
            findNavController().navigate(R.id.action_subjectUpdateFragment_to_subjectListFragment)
        }else {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String): Boolean{
        return !(TextUtils.isEmpty(name))
    }
}