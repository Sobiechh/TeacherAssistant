package com.example.teacherassistant.model.SubjectGroup

import androidx.lifecycle.LiveData
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubjectGroupRepository(private val subjectGroupDao: SubjectGroupDao) {

    val readAllData: LiveData<List<SubjectGroup>> = subjectGroupDao.readAllData()

    suspend fun addSubjectGroup(subjectGroup: SubjectGroup){
        subjectGroupDao.addSubjectGroup(subjectGroup)
    }

    fun getSubjectStudents(id:Int) = subjectGroupDao.getSubjectStudents(id)

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            subjectGroupDao.clearTable()
            //subject1
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1,
                student = Student(1, "A", "B"), subject = Subject(1, "Kotlin")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 2,
                student = Student(1, "B", "D"), subject = Subject(1, "Kotlin")
            ))
            //subject2
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 3,
                student = Student(1, "A", "B"), subject = Subject(2, "Python")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 4,
                student = Student(1, "B", "D"), subject = Subject(2, "Python")
            ))
            //subject3
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 5,
                student = Student(1, "A", "B"), subject = Subject(3, "Math")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 6,
                student = Student(1, "B", "D"), subject = Subject(3, "Math")
            ))
        }
    }
}