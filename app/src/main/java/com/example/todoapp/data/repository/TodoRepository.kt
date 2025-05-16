package com.example.todoapp.data.repository

import com.example.todoapp.data.local.TodoDao
import com.example.todoapp.data.local.TodoEntity

import com.example.todoapp.data.remote.TodoApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(
    private val api: TodoApiService,
    private val dao: TodoDao
) {
    // Expose cached todos as a Flow
    fun observeTodos(): Flow<List<TodoEntity>> = dao.getAllTodos()

    // Fetch from network and update DB
    suspend fun refreshTodos() {
        try {
            val todosDto = api.fetchTodos()
            val entities = todosDto.map { dto ->
                TodoEntity(dto.id, dto.userId, dto.title, dto.completed)
            }
            dao.insertTodos(entities)
        } catch (e: Exception) {
            throw e // Let ViewModel handle the error
        }
    }

    // Get a single todo by ID (from cache)
    fun getTodoById(id: Int): Flow<TodoEntity> = dao.getTodoById(id)
}

