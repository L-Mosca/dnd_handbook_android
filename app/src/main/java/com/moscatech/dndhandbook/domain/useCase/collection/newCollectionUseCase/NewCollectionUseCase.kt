package com.moscatech.dndhandbook.domain.useCase.collection.newCollectionUseCase

import com.moscatech.dndhandbook.data.repository.collection.CollectionContract
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class NewCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract,
) {
    suspend fun invoke(collection: MonsterCollection): Long? {
        with(collection) {
            val data = setupCollectionId()
            return collectionRepository.saveCollection(
                data.copy(monsterList = data.monsterList?.sortedBy { it.name })
            )
        }
    }
}