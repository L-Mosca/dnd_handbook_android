package com.example.dndhandbook.presentation.screen.newCollection

import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.collection.MonsterCollection

data class NewCollectionUIState(
    val monster: DefaultObject? = null,
    val collection: MonsterCollection = MonsterCollection(),
    val saveSuccess: Boolean = false,
)