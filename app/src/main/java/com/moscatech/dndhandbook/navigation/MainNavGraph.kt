package com.moscatech.dndhandbook.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.moscatech.dndhandbook.presentation.screen.home.HomeScreen
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.MonsterDetailScreen
import com.moscatech.dndhandbook.presentation.screen.splash.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val route: String)

@Serializable
data object SplashRoute : Route(route = "splashRoute")

@Serializable
data object HomeRoute : Route(route = "homeRoute")

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = SplashRoute) {
        animatedComposable<SplashRoute> {
            SplashScreen(
                navigateToHome = {
                    navController.navigate(HomeRoute) {
                        popUpTo(SplashRoute) { inclusive = true }
                    }
                }
            )
        }

        animatedComposable<HomeRoute> {
            HomeScreen(
                navigateToCollection = { navController.navigate(NewCollectionNavGraph(it)) },
                navigateToBestiary = { navController.navigate(BestiaryRoute) },
            )
        }

        composable(
            route = "monsterDetailDeepRoute/{deepLinkMonsterIndex}",
            arguments = listOf(
                navArgument("deepLinkMonsterIndex") { type = NavType.StringType },
            ),
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://meuapp/monsterDetailDeepRoute/{deepLinkMonsterIndex}"
                }
            )
        ) {
            MonsterDetailScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }

        createCharNavGraph(navController)
        bestiaryNavGraph(navController)
        newCollectionNavGraph(navController)
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