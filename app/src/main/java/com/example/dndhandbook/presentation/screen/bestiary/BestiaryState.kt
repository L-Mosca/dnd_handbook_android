package com.example.dndhandbook.presentation.screen.bestiary

import com.example.dndhandbook.domain.models.monster.MonsterList

data class BestiaryState(
    val isLoading: Boolean = false,
    val monsterList: MonsterList = MonsterList(),
    val filterList: MonsterList = MonsterList(),
    val error: String = ""
)
