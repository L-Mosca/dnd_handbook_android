package com.example.dndhandbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.dndhandbook.presentation.screen.monsterDetail.MonsterDetailScreen
import com.example.dndhandbook.presentation.screen.monsterList.MonsterListScreen
import com.example.dndhandbook.presentation.screen.newCollection.NewCollectionScreen
import kotlinx.serialization.Serializable

@Serializable
data class NewCollectionNavGraph(val collectionName: String = "")

@Serializable
data class NewCollectionRoute(val collectionName: String = "") : Route(route = "newCollectionRoute")

@Serializable
data class MonsterListRoute(val collectionName: String = "") : Route(route = "monsterListRoute")

fun NavGraphBuilder.newCollectionNavGraph(navController: NavHostController) {

    navigation<NewCollectionNavGraph>(startDestination = NewCollectionRoute()) {
        animatedComposable<NewCollectionRoute> {
            NewCollectionScreen(navController)
        }

        animatedComposable<MonsterListRoute> {
            MonsterListScreen(navController)
        }

        animatedComposable<MonsterDetailRoute> {
            MonsterDetailScreen(navController)
        }
    }
}