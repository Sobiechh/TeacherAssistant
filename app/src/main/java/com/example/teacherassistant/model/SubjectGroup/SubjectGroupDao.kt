package com.example.teacherassistant.model.SubjectGroup

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SubjectGroupDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubjectGroup(subjectGroup: SubjectGroup)

    @Query("SELECT * FROM subjectGroup_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<SubjectGroup>>

}