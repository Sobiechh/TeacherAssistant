package com.example.teacherassistant.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subjects")
data class Subject (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)