package com.example.teacherassistant.model.Mark

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMark(mark: Mark)

    @Query("SELECT * FROM mark_table WHERE idSubject = :idSubject")
    fun readSubjectData(idSubject: Int): LiveData<List<Mark>>

    @Update
    suspend fun updateMark(mark: Mark)

    @Query("DELETE FROM mark_table")
    suspend fun clearTable()

    @Query("SELECT * FROM mark_table WHERE DATE('now', '-1 days')")
    fun getTodayMarks(): LiveData<List<Mark>>

}