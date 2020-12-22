package com.example.teacherassistant.model.Mark

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject

@Entity(
    tableName = "mark_table",
    foreignKeys  = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["id"],
            childColumns = ["studentID"],
            onDelete= ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Subject::class,
            parentColumns = ["id"],
            childColumns = ["subjectID"],
            onDelete= ForeignKey.CASCADE
        )
    ]
)
data class Mark (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentID: Int,
    val subjectID: Int,
    val note: String= "",
    val grade: Double,
    val date: String
)