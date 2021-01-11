package com.example.teacherassistant.model.Mark

import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarkRepository(private val markDao: MarkDao) {

    fun readAllData(id:Int) = markDao.readAllData(id)

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

            markDao.addMark(Mark(1, Student(1,"Jan","Kal"), Subject(2,"Python"), "note1",4.5,"13-06-2020"))
//            markDao.addMark(Mark(idMark = 2 , note="Note2", grade = 3.5, date="23-06-2021"))
//            markDao.addMark(Mark(idMark = 3 , note="Note3", grade = 5.0, date="24-06-2021"))
//            markDao.addMark(Mark(idMark = 4 , note="Note4", grade = 5.0, date="11-06-2021"))
//
//            markDao.addMark(Mark(idMark = 5 , note="Note1", grade = 2.5, date="11-06-2020"))
//            markDao.addMark(Mark(idMark = 6 , note="Note2", grade = 3.5, date="24-06-2020"))
//            markDao.addMark(Mark(idMark = 7 , note="Note3", grade = 4.5, date="30-06-2020"))
//            markDao.addMark(Mark(idMark = 8 , note="Note4", grade = 5.0, date="02-06-2020"))
//
//            markDao.addMark(Mark(idMark = 9 , note="Note1", grade = 3.5, date="05-06-2020"))
//            markDao.addMark(Mark(idMark = 10, note="Note2", grade = 3.5, date="13-06-2020"))
//            markDao.addMark(Mark(idMark = 11, note="Note3", grade = 2.0, date="11-06-2020"))
//            markDao.addMark(Mark(idMark = 12, note="Note4", grade = 4.0, date="23-06-2020"))
        }
    }
}