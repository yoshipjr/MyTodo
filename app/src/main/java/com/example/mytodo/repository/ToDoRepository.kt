package com.example.mytodo.repository

import com.example.mytodo.model.todo.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun create(title: String, detail: String)

    fun getAll() : Flow<List<ToDo>>
}
