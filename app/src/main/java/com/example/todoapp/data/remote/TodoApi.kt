package com.example.todoapp.data.remote

import retrofit2.http.GET

interface TodoApiService {
    @GET("todos")
    suspend fun fetchTodos(): List<TodoDto>
}
