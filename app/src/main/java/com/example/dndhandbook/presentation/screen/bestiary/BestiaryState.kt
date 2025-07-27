package com.example.dndhandbook.presentation.screen.bestiary

import com.example.dndhandbook.domain.models.base.DefaultList

data class BestiaryState(
    val isLoading: Boolean = false,
    val monsterList: DefaultList = DefaultList(),
    val filterList: DefaultList = DefaultList(),
    val error: String = "",
)
