package com.example.dndhandbook.presentation.screen.create_character

import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.domain.models.Character
import com.example.dndhandbook.domain.models.race.RaceList
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail

data class CreateCharacterState(
    val character: Character? = null,
    val raceList: RaceList = RaceList(),
    val subRaceList: RaceList = RaceList(),
    val subRaceDetail: SubRaceDetail = SubRaceDetail(),
    val step: Int = Constants.CC_CHOSE_RACE,
    val isLoading: Boolean = false,
    val error: String = ""
)