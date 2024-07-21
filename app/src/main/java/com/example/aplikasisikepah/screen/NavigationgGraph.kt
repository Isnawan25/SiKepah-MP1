package com.example.aplikasisikepah.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavigationGraph(navController: NavController) {
    NavHost(navController = navController as NavHostController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(Routes.HISTORY_SCREEN) {
            HistoryScreen(navController = navController)
        }
        composable(Routes.PICKUP_SCREEN) {
            PickUpScreen(navController = navController)
        }
    }
}
