package com.example.teacherassistant.model.Student

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val surname: String
)