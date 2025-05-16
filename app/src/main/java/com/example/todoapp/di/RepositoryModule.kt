package com.example.todoapp.di

import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.data.remote.TodoApiService
import com.example.todoapp.data.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// In di/RepositoryModule.kt
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideTodoRepository(api: TodoApiService, dao: TodoDao): TodoRepository =
        TodoRepository(api, dao)
}
