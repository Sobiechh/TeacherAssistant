package com.example.teacherassistant.model.Subject

import androidx.lifecycle.LiveData

class SubjectRepository(private val subjectDao: SubjectDao) {

    val readAllData: LiveData<List<Subject>> = subjectDao.readAllData()

    suspend fun addSubject(subject: Subject){
        subjectDao.addSubject(subject)
    }

}