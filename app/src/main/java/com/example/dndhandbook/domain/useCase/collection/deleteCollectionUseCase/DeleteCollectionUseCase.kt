package com.example.dndhandbook.domain.useCase.collection.deleteCollectionUseCase

import com.example.dndhandbook.data.repository.collection.CollectionContract
import javax.inject.Inject

class DeleteCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract
) {
    suspend fun invoke(id: Long?) {
        id?.let {
            collectionRepository.getCollection(it)?.let { collection ->
                collectionRepository.deleteCollection(collection.id)
            }
        }
    }
}