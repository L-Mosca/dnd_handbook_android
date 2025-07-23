package com.example.dndhandbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.dndhandbook.presentation.screen.monsterDetail.MonsterDetailScreen
import com.example.dndhandbook.presentation.screen.monsterList.MonsterListScreen
import com.example.dndhandbook.presentation.screen.newCollection.NewCollectionScreen
import kotlinx.serialization.Serializable

@Serializable
data object NewCollectionNavGraph

@Serializable
data object NewCollectionRoute : Route(route = "newCollectionRoute")

@Serializable
data object MonsterListRoute : Route(route = "monsterListRoute")

fun NavGraphBuilder.newCollectionNavGraph(navController: NavHostController) {

    navigation<NewCollectionNavGraph>(startDestination = NewCollectionRoute) {
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