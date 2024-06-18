package com.example.dndhandbook.presentation.screen.monster_detail

import com.example.dndhandbook.domain.models.monster.MonsterDetail

data class MonsterDetailState (
    val isLoading: Boolean = false,
    val monsterDetail: MonsterDetail = MonsterDetail(),
    val error: String = ""
)