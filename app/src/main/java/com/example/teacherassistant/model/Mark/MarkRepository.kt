package com.example.teacherassistant.model.Mark

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarkRepository(private val markDao: MarkDao) {

    fun readSubjectData(id:Int) = markDao.readSubjectData(id)

    fun getTodayMarks() = markDao.getTodayMarks()

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
        }
    }
}