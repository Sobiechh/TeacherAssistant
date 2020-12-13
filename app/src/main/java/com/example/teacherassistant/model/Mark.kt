package com.example.teacherassistant.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Marks")
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    val grade: Double,
    val gradeDate: Date
)