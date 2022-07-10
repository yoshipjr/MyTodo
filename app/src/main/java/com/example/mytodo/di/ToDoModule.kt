package com.example.mytodo.di

import android.content.Context
import androidx.room.Room
import com.example.mytodo.model.todo.ToDoDAO
import com.example.mytodo.model.todo.ToDoDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ToDoModule {

    @Singleton
    @Provides
    fun provideToDoDatabase(
        @ApplicationContext context: Context
    ): ToDoDataBase {
        return  Room.databaseBuilder(
            context,
            ToDoDataBase::class.java,
            "todo.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideToDoDAO(db: ToDoDataBase): ToDoDAO {
        return db.todoDAO()
    }
}
