package com.example.teacherassistant

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.view.*

class WelcomeFragment : Fragment(R.layout.fragment_welcome)
{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        view.navToStudents.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_studentListFragment)
        }

        view.navToLessons.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_subjectListFragment)
        }

        view.navToToday.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_todayFragment)
        }
    }
}