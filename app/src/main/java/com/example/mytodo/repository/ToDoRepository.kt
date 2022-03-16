package com.example.mytodo.repository

interface ToDoRepository {
    suspend fun create(title: String, detail: String)
}
