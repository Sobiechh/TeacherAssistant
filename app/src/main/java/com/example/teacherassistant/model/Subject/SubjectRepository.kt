package com.example.teacherassistant.model.Subject

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubjectRepository(private val subjectDao: SubjectDao) {

    val readAllData: LiveData<List<Subject>> = subjectDao.readAllData()

    suspend fun addSubject(subject: Subject){
        subjectDao.addSubject(subject)
    }

    suspend fun updateSubject(subject: Subject){
        subjectDao.updateSubject(subject)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            subjectDao.clearTable()

            subjectDao.addSubject(Subject(id = 1, name = "Kotlin"))
            subjectDao.addSubject(Subject(id = 2, name = "Python"))
            subjectDao.addSubject(Subject(id = 3, name = "Math"))
        }
    }
}