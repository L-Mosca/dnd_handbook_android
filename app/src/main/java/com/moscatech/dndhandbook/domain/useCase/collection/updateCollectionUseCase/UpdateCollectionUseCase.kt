package com.moscatech.dndhandbook.domain.useCase.collection.updateCollectionUseCase

import com.moscatech.dndhandbook.data.repository.collection.CollectionContract
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.domain.models.collection.isNewCollection
import javax.inject.Inject

class UpdateCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract
) {
    suspend fun invoke(collection: MonsterCollection) {
        collectionRepository.saveCollection(
            collection.copy(monsterList = collection.monsterList?.sortedBy { it.name })
        )
    }

    suspend fun invoke(id: Long?, monster: DefaultObject) {
        if (id.isNewCollection()) return

        id?.let { collectionId ->
            collectionRepository.getCollection(collectionId)?.let { data ->
                val list = data.monsterList?.toMutableList() ?: mutableListOf()
                list.add(monster)
                collectionRepository.saveCollection(
                    data.copy(monsterList = list.distinct().sortedBy { it.name })
                )
            }
        }
    }
}