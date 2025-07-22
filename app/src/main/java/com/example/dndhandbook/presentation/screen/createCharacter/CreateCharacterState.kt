package com.example.dndhandbook.presentation.screen.createCharacter

import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.domain.models.Character
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail

data class CreateCharacterState(
    val character: Character? = null,
    val raceList: DefaultList = DefaultList(),
    val subRaceList: DefaultList = DefaultList(),
    val subRaceDetail: SubRaceDetail = SubRaceDetail(),
    val classList: DefaultList = DefaultList(),
    val step: Int = Constants.CC_CHOSE_RACE,
    val isLoading: Boolean = false,
    val error: String = ""
)