package com.example.dndhandbook.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.presentation.screen.bestiary.BestiaryScreen
import com.example.dndhandbook.presentation.screen.home.HomeScreen
import com.example.dndhandbook.presentation.screen.monster_detail.MonsterDetailScreen
import com.example.dndhandbook.presentation.screen.splash.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(
            route = Screen.Home.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Bestiary.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }) {
            BestiaryScreen(navController = navController)
        }

        composable(
            route = "${Screen.MonsterDetail.route}/{${Constants.MONSTER_DETAIL_SCREEN_ARGUMENT}}",
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
            arguments = listOf(navArgument(Constants.MONSTER_DETAIL_SCREEN_ARGUMENT) {
                type = NavType.StringType
            })
        ) {
            MonsterDetailScreen(navController = navController)
        }
    }
}