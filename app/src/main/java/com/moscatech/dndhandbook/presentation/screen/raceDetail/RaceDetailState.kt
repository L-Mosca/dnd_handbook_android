package com.moscatech.dndhandbook.presentation.screen.raceDetail

import com.moscatech.dndhandbook.domain.models.race.RaceDetail

data class RaceDetailState(
    val isLoading: Boolean = false,
    val raceDetail: RaceDetail? = null,
    val error: String = ""
)