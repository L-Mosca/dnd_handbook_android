package com.moscatech.dndhandbook.domain.useCase.collection.deleteCollectionUseCase

import com.moscatech.dndhandbook.data.repository.collection.CollectionContract
import com.moscatech.dndhandbook.domain.models.collection.isNewCollection
import javax.inject.Inject

class DeleteCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionContract
) {
    suspend fun invoke(id: Long?) {
        if (id.isNewCollection()) return
        
        id?.let {
            collectionRepository.getCollection(it)?.let { collection ->
                collectionRepository.deleteCollection(collection.id)
            }
        }
    }
}