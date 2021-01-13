package com.example.teacherassistant.model.SubjectGroup

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Subject.Subject
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "subjectGroup_table")
data class SubjectGroup (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded
    val student: Student,
    @Embedded
    val subject: Subject
): Parcelable