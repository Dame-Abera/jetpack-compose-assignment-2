package com.example.todoapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.ui.todoList.TodoListScreen
import com.example.todoapp.ui.todoDetail.TodoDetailScreen
import com.example.todoapp.viewmodel.TodoListViewModel
import com.example.todoapp.viewmodel.TodoDetailViewModel
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "todo_list") {
        composable("todo_list") {
            // 1) Obtain the ViewModel
            val listViewModel: TodoListViewModel = hiltViewModel()

            // 2) Call the screen with all required params
            TodoListScreen(
                viewModel    = listViewModel,
                onTodoClick  = { id ->
                    navController.navigate("todo_detail/$id")
                },
                onRetry      = {
                    // re-trigger your load logic
                    listViewModel.refreshTodos()
                }
            )
        }

        composable(
            "todo_detail/{todoId}",
            arguments = listOf(navArgument("todoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val todoId = backStackEntry.arguments?.getInt("todoId") ?: return@composable

            // Detail screen already takes onBackClick
            TodoDetailScreen(
                todoId      = todoId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}

