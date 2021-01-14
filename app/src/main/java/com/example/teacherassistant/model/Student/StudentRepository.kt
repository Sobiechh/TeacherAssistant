package com.example.teacherassistant.model.Student

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAllData()

    suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
//            studentDao.clearTable()

//            studentDao.addStudent(Student(idStudent = 1, nameStudent = "Piotr",    surnameStudent = "Sakwa"))
//            studentDao.addStudent(Student(idStudent = 2, nameStudent = "Jan",      surnameStudent = "Kot"))
//            studentDao.addStudent(Student(idStudent = 3, nameStudent = "Kamila",   surnameStudent = "Kowalska"))
//            studentDao.addStudent(Student(idStudent = 4, nameStudent = "Karolina", surnameStudent = "Gara"))
//            studentDao.addStudent(Student(idStudent = 5, nameStudent = "Karol",    surnameStudent = "Jotko"))
//            studentDao.addStudent(Student(idStudent = 6, nameStudent = "Filip",    surnameStudent = "Rataj"))
//            studentDao.addStudent(Student(idStudent = 7, nameStudent = "Oskar",    surnameStudent = "Trela"))
//            studentDao.addStudent(Student(idStudent = 8, nameStudent = "Anna",     surnameStudent = "Kossak"))
//            studentDao.addStudent(Student(idStudent = 9, nameStudent = "Aneta",    surnameStudent = "Robak"))
        }
    }
}