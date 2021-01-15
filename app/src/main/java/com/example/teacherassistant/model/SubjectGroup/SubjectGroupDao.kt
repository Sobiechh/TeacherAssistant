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

    @Query("SELECT * FROM subjectGroup_table WHERE idSubject = :idSubject")
    fun getSubjectStudents(idSubject: Int): LiveData<List<SubjectGroup>>

    @Query("SELECT  DISTINCT *  FROM subjectGroup_table WHERE idSubject != :idSubject OR idSubject = 1000")
    fun getStudentsNotInSubject(idSubject: Int): LiveData<List<SubjectGroup>>

    @Query("DELETE FROM subjectGroup_table WHERE nameStudent = :nameStudent AND surnameStudent = :surnameStudent AND idSubject = 1000")
    suspend fun deleteEmptyStudentGroup(nameStudent: String, surnameStudent: String)

    @Query("UPDATE subjectGroup_table SET nameStudent = :newNameStudent, surnameStudent = :newSurnameStudent WHERE nameStudent = :oldNameStudent AND surnameStudent = :oldSurnameStudent")
    suspend fun updateStudentNameInStudentGrup(oldNameStudent: String, oldSurnameStudent: String, newNameStudent: String, newSurnameStudent:String)

    @Query("DELETE FROM subject_table")
    suspend fun clearTable()
}