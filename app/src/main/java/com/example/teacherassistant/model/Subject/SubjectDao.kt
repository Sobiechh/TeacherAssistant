package com.example.teacherassistant.model.Subject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubject(subject: Subject)

    @Query("SELECT * FROM subject_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Subject>>
}