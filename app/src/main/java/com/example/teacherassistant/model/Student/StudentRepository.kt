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
            studentDao.clearTable()

            studentDao.addStudent(Student(id = 1, name = "Piotr",    surname = "Sakwa"))
            studentDao.addStudent(Student(id = 2, name = "Jan",      surname = "Kot"))
            studentDao.addStudent(Student(id = 3, name = "Kamila",   surname = "Kowalska"))
            studentDao.addStudent(Student(id = 4, name = "Karolina", surname = "Gara"))
            studentDao.addStudent(Student(id = 5, name = "Karol",    surname = "Jotko"))
            studentDao.addStudent(Student(id = 6, name = "Filip",    surname = "Rataj"))
            studentDao.addStudent(Student(id = 7, name = "Oskar",    surname = "Trela"))
            studentDao.addStudent(Student(id = 8, name = "Anna",     surname = "Kossak"))
            studentDao.addStudent(Student(id = 9, name = "Aneta",    surname = "Robak"))
        }
    }
}