package com.moscatech.dndhandbook.presentation.screen.home

import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection

data class HomeUIState(
    val collectionList: List<MonsterCollection> = emptyList(),
) {
    fun setCollectionList(list: List<MonsterCollection>) = copy(
        collectionList = list
    )
}