package com.example.teacherassistant.model.SubjectGroup

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubjectGroupRepository(private val subjectGroupDao: SubjectGroupDao) {

    val readAllData: LiveData<List<SubjectGroup>> = subjectGroupDao.readAllData()

    suspend fun addSubjectGroup(subjectGroup: SubjectGroup){
        subjectGroupDao.addSubjectGroup(subjectGroup)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            subjectGroupDao.clearTable()

//            //subject1
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 1, subjectID = 1))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 2, subjectID = 1))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 4, subjectID = 1))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 6, subjectID = 1))
//            //subject2
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 7, subjectID = 2))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 1, subjectID = 2))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 3, subjectID = 2))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 5, subjectID = 2))
//            //subject3
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 6, subjectID = 3))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 9, subjectID = 3))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 8, subjectID = 3))
//            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1, studentID = 5, subjectID = 3))
        }
    }
}