package com.example.mytodo.model.todo

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDAO {

    @Query("select * from ToDo where created < :startCreated order by created desc limit :limit")
    fun getWithCreated(startCreated: Long, limit: Int): Flow<List<ToDo>>

    @Insert
    suspend fun create(todo: ToDo)

    @Update
    suspend fun update(todo: ToDo)

    @Delete
    suspend fun delete(todo: ToDo)
}
