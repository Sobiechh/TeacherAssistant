package com.example.teacherassistant.model.Mark

import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class MarkRepository(private val markDao: MarkDao) {

    fun readSubjectData(id:Int) = markDao.readSubjectData(id)

    suspend fun addMark(mark: Mark){
        markDao.addMark(mark)
    }

    suspend fun updateStudent(mark: Mark) {
        markDao.updateMark(mark)
    }

    suspend fun mockData() {
        withContext(Dispatchers.IO)
        {
            markDao.clearTable()

            markDao.addMark(Mark(1, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",4.5,Date(System.currentTimeMillis() - 86_400_000)))
            markDao.addMark(Mark(2, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",5.0,Date(System.currentTimeMillis() - 86_400_000)))
            markDao.addMark(Mark(3, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",2.5,Date(System.currentTimeMillis() )))
            markDao.addMark(Mark(4, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",2.5,Date(System.currentTimeMillis() )))
            markDao.addMark(Mark(5, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",2.5,Date(System.currentTimeMillis() )))
            markDao.addMark(Mark(6, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",2.5,Date(System.currentTimeMillis() - 86_400_000)))
            markDao.addMark(Mark(7, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",1.0,Date(System.currentTimeMillis() - 86_400_000)))
        }
    }
}