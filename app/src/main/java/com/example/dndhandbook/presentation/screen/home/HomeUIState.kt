package com.example.dndhandbook.presentation.screen.home

import com.example.dndhandbook.domain.models.collection.MonsterCollection

data class HomeUIState(
    val collectionList: List<MonsterCollection> = emptyList(),
    val collectionSelected: MonsterCollection? = null,
)