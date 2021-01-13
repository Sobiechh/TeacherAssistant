package com.example.teacherassistant.model.Mark

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import java.util.*

@Entity(
    tableName = "mark_table"
)
@TypeConverters(DateConverter::class)
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val idMark: Int,
    @Embedded
    val student: Student,
    @Embedded
    val subject: Subject,
    val note: String= "",
    val grade: Double,
    val date: Date
)