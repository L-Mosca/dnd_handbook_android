package com.example.dndhandbook.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Splash : Screen("splash_screen")
    object Bestiary : Screen("bestiary_screen")
    object MonsterDetail: Screen("monster_detail")
    object CreateCharacter: Screen("create_character")
}