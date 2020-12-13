package com.example.teacherassistant.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "SubjectGroups",
    foreignKeys  = [
    ForeignKey(
        entity = Student::class,
        parentColumns = ["id"],
        childColumns = ["studentID"],
        onDelete= CASCADE
    ),
    ForeignKey(
        entity = Subject::class,
        parentColumns = ["id"],
        childColumns = ["subjectID"],
        onDelete= CASCADE
    ),
    ]
)
data class SubjectGroup (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val studentID: Int,
    val subjectID: Int
)