package com.example.dndhandbook.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Splash : Screen("splash_screen")
    object Bestiary : Screen("bestiary_screen")
    object MonsterDetail: Screen("monster_detail")
    object CreateCharacter: Screen("create_character")
    object RaceDetail: Screen("race_detail")
    object SubRaceDetail: Screen("sub_race_detail")
    object ClassDetail: Screen("class_detail")
}