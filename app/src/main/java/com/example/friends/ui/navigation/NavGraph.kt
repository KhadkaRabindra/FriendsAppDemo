package com.example.friends.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.friends.domain.utils.Screen
import com.example.friends.ui.details.UserDetailsScreen
import com.example.friends.ui.home.HomeScreen
import com.example.friends.ui.viewmodel.UserViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController, viewModel: UserViewModel, context: Context
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.Details.route) {
            UserDetailsScreen(
                navController = navController,
                user = viewModel.selectedUser!!
            )
        }
    }
}