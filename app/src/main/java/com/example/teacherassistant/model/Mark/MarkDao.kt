package com.example.teacherassistant.model.Mark

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarkDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMark(mark: Mark)

    @Query("SELECT * FROM mark_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Mark>>


}