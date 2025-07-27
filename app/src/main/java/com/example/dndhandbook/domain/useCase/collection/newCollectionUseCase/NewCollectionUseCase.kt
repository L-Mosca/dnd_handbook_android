package com.example.dndhandbook.domain.useCase.collection.newCollectionUseCase

import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class NewCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract,
) {
    suspend fun invoke(collection: MonsterCollection): Long? {
        return collectionRepository.saveCollection(collection)
    }
}