package com.example.dndhandbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.dndhandbook.presentation.screen.bestiary.BestiaryScreen
import com.example.dndhandbook.presentation.screen.monsterDetail.MonsterDetailScreen
import kotlinx.serialization.Serializable

@Serializable
data object BestiaryNavGraph

@Serializable
data object BestiaryRoute : Route(route = "bestiaryRoute")

@Serializable
data class MonsterDetailRoute(
    val collectionId: Long? = null,
    val monsterIndex: String,
    val isFromCollection: Boolean
) : Route(route = "monsterDetailRoute")

fun NavGraphBuilder.bestiaryNavGraph(navController: NavHostController) {

    navigation<BestiaryNavGraph>(startDestination = BestiaryRoute) {
        animatedComposable<BestiaryRoute> {
            BestiaryScreen(
                onBackPressed = { navController.navigateUp() },
                navigateToMonsterDetail = {
                    navController.navigate(
                        MonsterDetailRoute(
                            monsterIndex = it,
                            collectionId = null,
                            isFromCollection = false,
                        )
                    )
                }
            )
        }

        animatedComposable<MonsterDetailRoute> {
            MonsterDetailScreen()
        }
    }
}