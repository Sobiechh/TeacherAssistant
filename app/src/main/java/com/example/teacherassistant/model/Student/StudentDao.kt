package com.example.teacherassistant.model.Student

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Student>>
}