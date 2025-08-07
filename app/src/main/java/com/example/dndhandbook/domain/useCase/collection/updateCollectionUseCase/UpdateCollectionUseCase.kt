package com.example.dndhandbook.domain.useCase.collection.updateCollectionUseCase

import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.domain.models.collection.isNewCollection
import javax.inject.Inject

class UpdateCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract
) {
    suspend fun invoke(collection: MonsterCollection) {
        collectionRepository.saveCollection(collection)
    }

    suspend fun invoke(id: Long?, monster: DefaultObject) {
        if (id.isNewCollection()) return

        id?.let {
            collectionRepository.getCollection(it)?.let { data ->
                val list = data.monsterList?.toMutableList() ?: mutableListOf()
                list.add(monster)
                collectionRepository.saveCollection(
                    data.copy(monsterList = list.distinct())
                )
            }
        }
    }
}