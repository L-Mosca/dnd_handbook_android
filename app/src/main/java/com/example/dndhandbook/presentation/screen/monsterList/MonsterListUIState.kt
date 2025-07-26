package com.example.dndhandbook.presentation.screen.monsterList

import com.example.dndhandbook.domain.models.base.DefaultList

data class MonsterListUIState(
    val filter: String = "",
    val isLoading: Boolean = false,
    val monsterList: DefaultList = DefaultList(),
    val filterList: DefaultList = DefaultList(),
    val error: String = "",
    val collectionName: String = "",
)