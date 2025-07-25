package com.example.dndhandbook.presentation.screen.newCollection

import com.example.dndhandbook.domain.models.base.DefaultObject

data class NewCollectionUIState(
    val monster: DefaultObject? = null,
    val monsterList: List<DefaultObject> = emptyList(),
    val collectionName: String = "",
    val saveSuccess: Boolean = false,
)