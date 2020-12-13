package com.example.teacherassistant.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val surname: String
)