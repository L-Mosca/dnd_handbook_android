package com.example.dndhandbook.presentation.screen.create_character

import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.domain.models.race.RaceList

data class CreateCharacterState(
    val character: Any? = null,
    val raceList: RaceList = RaceList(),
    val step: Int = Constants.CC_CHOSE_RACE,
    val isLoading: Boolean = false,
    val error: String = ""
)