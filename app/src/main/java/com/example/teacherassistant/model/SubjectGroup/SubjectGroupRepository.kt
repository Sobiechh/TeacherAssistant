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

    suspend fun deleteEmptyStudentGroup(nameStudent: String, surnameStudent: String) = subjectGroupDao.deleteEmptyStudentGroup(nameStudent, surnameStudent)

    fun getSubjectStudents(id:Int) = subjectGroupDao.getSubjectStudents(id)

    fun getStudentsNotInSubject(idSubject:Int) = subjectGroupDao.getStudentsNotInSubject(idSubject)

    suspend fun updateStudentNameInStudentGrup(oldNameStudent: String, oldSurnameStudent: String, newNameStudent: String, newSurnameStudent:String) = subjectGroupDao.updateStudentNameInStudentGrup(oldNameStudent, oldSurnameStudent, newNameStudent, newSurnameStudent)

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
//            subjectGroupDao.clearTable()

            // subject1
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 1,
                student = Student(idStudent = 1, nameStudent = "Piotr",    surnameStudent = "Sakwa"), subject = Subject(1, "Kotlin")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 2,
                student = Student(idStudent = 2, nameStudent = "Jan",      surnameStudent = "Kot"), subject = Subject(1, "Kotlin")
            ))
            //subject2
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 3,
                student = Student(idStudent = 3, nameStudent = "Kamila",   surnameStudent = "Kowalska"), subject = Subject(2, "Python")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 4,
                student = Student(idStudent = 4, nameStudent = "Karolina", surnameStudent = "Gara"), subject = Subject(2, "Python")
            ))
            //subject3
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 5,
                student = Student(idStudent = 5, nameStudent = "Karol",    surnameStudent = "Jotko"), subject = Subject(3, "Math")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 6,
                student = Student(idStudent = 6, nameStudent = "Filip",    surnameStudent = "Rataj"), subject = Subject(3, "Math")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 7,
                    student = Student(idStudent = 7, nameStudent = "Oskar",    surnameStudent = "Trela"), subject = Subject(0,"a")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 8,
                    student = Student(idStudent = 8, nameStudent = "Anna",     surnameStudent = "Kossak"), subject = Subject(0, "a")
            ))
            subjectGroupDao.addSubjectGroup(SubjectGroup(id = 9,
                    student = Student(idStudent = 9, nameStudent = "Aneta",    surnameStudent = "Robak"), subject = Subject(0, "a")
            ))
        }
    }
}