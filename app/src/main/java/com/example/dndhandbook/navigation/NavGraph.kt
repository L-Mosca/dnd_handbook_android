package com.example.dndhandbook.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dndhandbook.presentation.screen.bestiary.BestiaryScreen
import com.example.dndhandbook.presentation.screen.classDetail.ClassDetailScreen
import com.example.dndhandbook.presentation.screen.createCharacter.CreateCharacterScreen
import com.example.dndhandbook.presentation.screen.home.HomeScreen
import com.example.dndhandbook.presentation.screen.monsterDetail.MonsterDetailScreen
import com.example.dndhandbook.presentation.screen.raceDetail.RaceDetailScreen
import com.example.dndhandbook.presentation.screen.splash.SplashScreen
import com.example.dndhandbook.presentation.screen.subRaceDetail.SubRaceDetailScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val route: String)

@Serializable
object SplashRoute : Route(route = "splashRoute")

@Serializable
object HomeRoute : Route(route = "homeRoute")

@Serializable
object BestiaryRoute : Route(route = "bestiaryRoute")

@Serializable
data class MonsterDetailRoute(val monsterIndex: String) : Route(route = "monsterDetailRoute")

@Serializable
data object CreateCharacterRoute : Route(route = "createCharacterRoute")

@Serializable
data class RaceDetailRoute(val raceIndex: String) : Route(route = "raceDetailRoute")

@Serializable
data class SubRaceDetailRoute(val subRaceIndex: String) : Route(route = "subRaceDetailRoute")

@Serializable
data class ClassDetailRoute(val classIndex: String) : Route(route = "classDetailRoute")

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = SplashRoute) {
        animatedComposable<SplashRoute> {
            SplashScreen(navController)
        }

        animatedComposable<HomeRoute> {
            HomeScreen(navController)
        }

        animatedComposable<BestiaryRoute> {
            BestiaryScreen(navController)
        }

        animatedComposable<MonsterDetailRoute> {
            MonsterDetailScreen(navController)
        }

        animatedComposable<CreateCharacterRoute> {
            CreateCharacterScreen(navController)
        }

        animatedComposable<RaceDetailRoute> {
            RaceDetailScreen(navController)
        }

        animatedComposable<SubRaceDetailRoute> {
            SubRaceDetailScreen(navController)
        }

        animatedComposable<ClassDetailRoute> {
            ClassDetailScreen(navController)
        }
    }
}

inline fun <reified T> NavGraphBuilder.animatedComposable(
    noinline content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) where T : Route {
    composable<T>(
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
        content = content,
    )
}