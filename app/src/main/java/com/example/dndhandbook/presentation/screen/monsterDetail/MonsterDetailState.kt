package com.example.dndhandbook.presentation.screen.monsterDetail

import com.example.dndhandbook.domain.models.monster.MonsterDetail

data class MonsterDetailState(
    val isLoading: Boolean = false,
    val monsterDetail: MonsterDetail = MonsterDetail(),
    val error: String = "",
    val isFromCollection: Boolean = false,
    val navigateBack: Boolean = false,
    val collectionId: Long? = null,
)