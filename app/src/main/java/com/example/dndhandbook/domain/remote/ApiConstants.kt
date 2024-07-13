package com.example.dndhandbook.domain.remote

class ApiConstants {
    companion object {
        // Monster
        const val FETCH_MONSTERS = "/api/monsters"
        const val FETCH_MONSTER_DETAIL = "/api/monsters/{index}"

        // Race
        const val FETCH_RACE_LIST = "/api/races"

        // Sub Race
        const val FETCH_SUB_RACE = "/api/races/{index}/subraces"
        const val FETCH_SUB_RACE_DETAIL = "/api/subraces/{index}"

        // Classes
        const val FETCH_CLASSES = "/api/classes"
    }
}