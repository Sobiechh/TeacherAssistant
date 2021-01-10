package com.example.teacherassistant.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.teacherassistant.model.AppDatabase
import com.example.teacherassistant.model.Mark.Mark
import com.example.teacherassistant.model.Mark.MarkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class MarkViewModel(application: Application) : AndroidViewModel(application) {

//    abstract var readAllData: LiveData<List<Mark>>
    private val repository: MarkRepository

    init {
        val markDao = AppDatabase.getDatabase(application).markDao()
        repository = MarkRepository(markDao)
        viewModelScope.launch {
            repository.mockData()
        }
    }

    fun addMark(mark: Mark) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMark(mark)
        }
    }


    fun readAllData(id: Int): LiveData<List<Mark>> {
//        viewModelScope.launch(Dispatchers.IO) {
            return repository.readAllData(id)
//        }
    }
}