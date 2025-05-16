package com.example.todoapp.data.remote

import com.google.gson.annotations.SerializedName

data class TodoDto(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("completed") val completed: Boolean
)
