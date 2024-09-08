package com.example.dndhandbook.presentation.screen.race_detail

import com.example.dndhandbook.domain.models.race.RaceDetail

data class RaceDetailState(
    val isLoading: Boolean = false,
    val raceDetail: RaceDetail? = null,
    val error: String = ""
)