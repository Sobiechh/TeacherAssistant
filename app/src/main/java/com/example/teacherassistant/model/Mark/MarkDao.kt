package com.example.teacherassistant.model.Mark

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMark(mark: Mark)

    @Query("SELECT * FROM mark_table WHERE subjectID = :subjectID ORDER BY date DESC")
    fun readAllData(subjectID:Int): LiveData<List<Mark>>

    @Update
    suspend fun updateMark(mark: Mark)

    @Query("DELETE FROM mark_table")
    suspend fun clearTable()
}