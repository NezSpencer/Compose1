package com.nezspencer.compose1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: AppDestination,
    onNewTaskAdded: (title: String, description: String) -> Unit,
    modifier: Modifier
) {
    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(AppDestination.HOME.route) {
            Dashboard(modifier = modifier, navController = navController, onNewTaskAdded)
        }
        composable(AppDestination.DETAIL.route) {
            CalendarView(modifier)
        }
    }
}

enum class AppDestination(val route: String) {
    HOME("home"),
    DETAIL("detail")
}