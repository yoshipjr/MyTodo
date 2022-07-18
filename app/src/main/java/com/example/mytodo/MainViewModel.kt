package com.example.mytodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mytodo.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    val todoList = repository.getAll().asLiveData()
}
