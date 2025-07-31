package com.example.dndhandbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.dndhandbook.presentation.screen.monsterDetail.MonsterDetailScreen
import com.example.dndhandbook.presentation.screen.monsterList.MonsterListScreen
import com.example.dndhandbook.presentation.screen.newCollection.NewCollectionScreen
import kotlinx.serialization.Serializable

@Serializable
data class NewCollectionNavGraph(val id: Long? = null)

@Serializable
data class NewCollectionRoute(val id: Long? = null) : Route(route = "newCollectionRoute")

@Serializable
data class MonsterListRoute(val id: Long? = null) : Route(route = "monsterListRoute")

fun NavGraphBuilder.newCollectionNavGraph(navController: NavHostController) {

    navigation<NewCollectionNavGraph>(startDestination = NewCollectionRoute()) {
        animatedComposable<NewCollectionRoute> {
            NewCollectionScreen(
                onBackPressed = { navController.navigateUp() },
                onAddMonsterPressed = { navController.navigate(MonsterListRoute(it)) },
                onInfoClicked = { collectionId, monsterIndex ->
                    navController.navigate(
                        MonsterDetailRoute(
                            collectionId = collectionId,
                            monsterIndex = monsterIndex,
                            isFromCollection = false,
                        )
                    )
                }
            )
        }

        animatedComposable<MonsterListRoute> {
            MonsterListScreen(
                onBackPressed = { navController.navigateUp() },
                onMonsterClicked = { collectionId, monsterIndex ->
                    navController.navigate(
                        MonsterDetailRoute(
                            collectionId = collectionId,
                            monsterIndex = monsterIndex,
                            isFromCollection = true,
                        )
                    )
                }
            )
        }

        animatedComposable<MonsterDetailRoute> {
            MonsterDetailScreen(
                onMonsterAdded = { collectionId ->
                    navController.popBackStack(
                        route = NewCollectionRoute(collectionId),
                        inclusive = false,
                    )
                }
            )
        }
    }
}