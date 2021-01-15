package com.example.teacherassistant.model.Subject

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "subject_table")
data class Subject(
        @PrimaryKey(autoGenerate = true)
        val idSubject: Int,
        val nameSubject: String
): Parcelable