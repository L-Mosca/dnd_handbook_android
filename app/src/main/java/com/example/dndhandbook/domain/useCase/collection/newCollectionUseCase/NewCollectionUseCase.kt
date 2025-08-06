package com.example.dndhandbook.domain.useCase.collection.newCollectionUseCase

import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class NewCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract,
) {
    suspend fun invoke(collection: MonsterCollection): Long? {
        val data = if (collection.id == -1L) collection.copy(id = null) else collection.copy()
        return collectionRepository.saveCollection(data)
    }
}