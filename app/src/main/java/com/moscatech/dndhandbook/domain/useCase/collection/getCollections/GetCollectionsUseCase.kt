package com.moscatech.dndhandbook.domain.useCase.collection.getCollections

import com.moscatech.dndhandbook.data.repository.collection.CollectionContract
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class GetCollectionsUseCase @Inject constructor(private val repository: CollectionContract) {
    suspend fun invoke(): List<MonsterCollection> {
        return repository.getCollections().sortedBy { it.name }
    }
}