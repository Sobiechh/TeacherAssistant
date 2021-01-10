package com.example.teacherassistant.model.Mark

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarkRepository(private val markDao: MarkDao) {

    fun readAllData(id: Int) = markDao.readAllData(id)

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

            markDao.addMark(Mark(id = 1 , studentID = 1, subjectID = 1, note="Note1", grade = 4.0, date="13-06-2021"))
            markDao.addMark(Mark(id = 2 , studentID = 2, subjectID = 1, note="Note2", grade = 3.5, date="23-06-2021"))
            markDao.addMark(Mark(id = 3 , studentID = 4, subjectID = 1, note="Note3", grade = 5.0, date="24-06-2021"))
            markDao.addMark(Mark(id = 4 , studentID = 6, subjectID = 1, note="Note4", grade = 5.0, date="11-06-2021"))

            markDao.addMark(Mark(id = 5 , studentID = 7, subjectID = 2, note="Note1", grade = 2.5, date="11-06-2020"))
            markDao.addMark(Mark(id = 6 , studentID = 1, subjectID = 2, note="Note2", grade = 3.5, date="24-06-2020"))
            markDao.addMark(Mark(id = 7 , studentID = 3, subjectID = 2, note="Note3", grade = 4.5, date="30-06-2020"))
            markDao.addMark(Mark(id = 8 , studentID = 5, subjectID = 2, note="Note4", grade = 5.0, date="02-06-2020"))

            markDao.addMark(Mark(id = 9 , studentID = 6, subjectID = 3, note="Note1", grade = 3.5, date="05-06-2020"))
            markDao.addMark(Mark(id = 10, studentID = 9, subjectID = 3, note="Note2", grade = 3.5, date="13-06-2020"))
            markDao.addMark(Mark(id = 11, studentID = 8, subjectID = 3, note="Note3", grade = 2.0, date="11-06-2020"))
            markDao.addMark(Mark(id = 12, studentID = 5, subjectID = 3, note="Note4", grade = 4.0, date="23-06-2020"))
        }
    }
}