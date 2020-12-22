package com.example.teacherassistant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.view.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_welcome, container, false)

        view.navToStudents.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_studentListFragment)
        }

        view.navToLessons.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_lessonsFragment)
        }

        view.navToToday.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_todayFragment)
        }

        return view
    }
}