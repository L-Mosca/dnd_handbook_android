package com.example.dndhandbook.presentation.screen.monsterList

import com.example.dndhandbook.domain.models.base.DefaultList

data class MonsterListUIState(
    val isLoading: Boolean = false,
    val showError: Boolean = false,
    val showEmptyList: Boolean = false,
    val monsterList: DefaultList = DefaultList(),
    val filterList: DefaultList = DefaultList(),
    val filterText: String = "",
)