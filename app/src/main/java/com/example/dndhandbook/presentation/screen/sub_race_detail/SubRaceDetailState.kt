package com.example.dndhandbook.presentation.screen.sub_race_detail

import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail

data class SubRaceDetailState(
    val isLoading: Boolean = false,
    val subRaceDetail: SubRaceDetail? = null,
    val error: String = ""
)