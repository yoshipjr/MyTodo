package com.example.mytodo.di

import com.example.mytodo.repository.ToDoRepository
import com.example.mytodo.repository.ToDoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ToDoRepositoryModule {

    @Binds
    @Singleton
    abstract fun ToDoRepositoryImpl.bindToDoRepository(): ToDoRepository
}
