package com.example.dndhandbook.presentation.screen.monsterDetail

import com.example.dndhandbook.domain.models.monster.MonsterDetail

data class MonsterDetailState(
    val isLoading: Boolean = false,
    val monsterDetail: MonsterDetail? = null,
    val isFromCollection: Boolean = false,
    val navigateBack: Boolean = false,
    //val collectionId: Long? = null,
    val showError: Boolean = false,
)