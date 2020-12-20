package com.example.teacherassistant.model.Mark

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "mark_table")
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val note: String= "",
    val grade: Double,
    val date: Date= Date(0)
)