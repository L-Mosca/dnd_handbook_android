package com.example.dndhandbook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.dndhandbook.presentation.screen.newCollection.NewCollectionScreen
import kotlinx.serialization.Serializable

@Serializable
data object NewCollectionNavGraph

@Serializable
data object NewCollectionRoute : Route(route = "newCollectionRoute")

fun NavGraphBuilder.newCollectionNavGraph(navController: NavHostController) {

    navigation<NewCollectionNavGraph>(startDestination = NewCollectionRoute) {
        animatedComposable<NewCollectionRoute> {
            NewCollectionScreen(navController)
        }
    }
}