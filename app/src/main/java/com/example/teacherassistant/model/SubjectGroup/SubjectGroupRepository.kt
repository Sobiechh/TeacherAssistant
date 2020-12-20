package com.example.teacherassistant.model.SubjectGroup

import androidx.lifecycle.LiveData

class SubjectGroupRepository(private val subjectGroupDao: SubjectGroupDao) {

    val readAllData: LiveData<List<SubjectGroup>> = subjectGroupDao.readAllData()

    suspend fun addSubjectGroup(subjectGroup: SubjectGroup){
        subjectGroupDao.addSubjectGroup(subjectGroup)
    }

}