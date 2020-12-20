package com.example.teacherassistant.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teacherassistant.model.Mark.Mark
import com.example.teacherassistant.model.Mark.MarkDao
import com.example.teacherassistant.model.Student.Student
import com.example.teacherassistant.model.Student.StudentDao
import com.example.teacherassistant.model.Subject.Subject
import com.example.teacherassistant.model.Subject.SubjectDao
import com.example.teacherassistant.model.SubjectGroup.SubjectGroup
import com.example.teacherassistant.model.SubjectGroup.SubjectGroupDao

@Database(
        entities = [
            Mark::class,
            Student::class,
            Subject::class,
            SubjectGroup::class
                   ],
        version = 1,
        exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun markDao(): MarkDao
    abstract fun studentDao(): StudentDao
    abstract fun subjectDao(): SubjectDao
    abstract fun subjectGroupDao(): SubjectGroupDao


    companion object{
        @Volatile
        private  var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}