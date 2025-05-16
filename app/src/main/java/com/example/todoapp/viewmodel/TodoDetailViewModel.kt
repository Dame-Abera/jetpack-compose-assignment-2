package com.example.todoapp.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.local.TodoEntity
import com.example.todoapp.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TodoDetailViewModel @Inject constructor(
    private val repository: TodoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val todoId = checkNotNull(savedStateHandle["todoId"]) as Int

    private val _uiState = MutableStateFlow<TodoEntity?>(null)
    val uiState: StateFlow<TodoEntity?> = _uiState.asStateFlow()

    init {
        // Collect the todo with given ID from the cache
        viewModelScope.launch {
            repository.getTodoById(todoId).collect { todo ->
                _uiState.value = todo
            }
        }
    }
}
