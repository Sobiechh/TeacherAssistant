package com.example.teacherassistant.model.Mark

import androidx.lifecycle.LiveData

class MarkRepository(private val markDao: MarkDao) {

    val readAllData: LiveData<List<Mark>> = markDao.readAllData()

    suspend fun addMark(mark: Mark){
        markDao.addMark(mark)
    }

}