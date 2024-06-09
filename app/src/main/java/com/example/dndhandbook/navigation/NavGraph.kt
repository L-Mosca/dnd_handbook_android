package com.example.dndhandbook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dndhandbook.presentation.screen.bestiary.BestiaryScreen
import com.example.dndhandbook.presentation.screen.home.HomeScreen
import com.example.dndhandbook.presentation.screen.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Bestiary.route) {
            BestiaryScreen(navController = navController)
        }
    }
}