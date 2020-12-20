package com.example.teacherassistant.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AppDatabase
import com.example.teacherassistant.model.Subject.Subject
import com.example.teacherassistant.model.Subject.SubjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<Subject>>
    private val repository: SubjectRepository

    init {
        val subjectDao = AppDatabase.getDatabase(application).subjectDao()
        repository = SubjectRepository(subjectDao)
        readAllData = repository.readAllData
    }

    fun addSubject(subject: Subject) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSubject(subject)
        }
    }
}