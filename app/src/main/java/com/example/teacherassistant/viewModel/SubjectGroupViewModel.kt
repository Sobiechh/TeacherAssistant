package com.example.teacherassistant.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AppDatabase
import com.example.teacherassistant.model.SubjectGroup.SubjectGroup
import com.example.teacherassistant.model.SubjectGroup.SubjectGroupRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectGroupViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SubjectGroupRepository

    init {
        val subjectGroupDao = AppDatabase.getDatabase(application).subjectGroupDao()
        repository = SubjectGroupRepository(subjectGroupDao)
        viewModelScope.launch {
            repository.mockData()
        }
    }

    fun addSubjectGroup(subjectGroup: SubjectGroup) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSubjectGroup(subjectGroup)
        }
    }

    fun getSubjectStudents(idSubject: Int): LiveData<List<SubjectGroup>> {
        return repository.getSubjectStudents(idSubject)
    }
}