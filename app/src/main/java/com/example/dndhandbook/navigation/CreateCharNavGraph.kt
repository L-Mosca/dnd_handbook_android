package com.example.dndhandbook.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.dndhandbook.presentation.screen.classDetail.ClassDetailScreen
import com.example.dndhandbook.presentation.screen.createCharacter.CreateCharacterScreen
import com.example.dndhandbook.presentation.screen.raceDetail.RaceDetailScreen
import com.example.dndhandbook.presentation.screen.subRaceDetail.SubRaceDetailScreen
import kotlinx.serialization.Serializable

@Serializable
data object CreateCharacterNavGraph

@Serializable
data object CreateCharacterRoute : Route(route = "createCharacterRoute")

@Serializable
data class RaceDetailRoute(val raceIndex: String) : Route(route = "raceDetailRoute")

@Serializable
data class SubRaceDetailRoute(val subRaceIndex: String) : Route(route = "subRaceDetailRoute")

@Serializable
data class ClassDetailRoute(val classIndex: String) : Route(route = "classDetailRoute")

fun NavGraphBuilder.createCharNavGraph(navController: NavHostController) {

    navigation<CreateCharacterNavGraph>(startDestination = CreateCharacterRoute) {
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