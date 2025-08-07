package com.example.dndhandbook.domain.useCase.collection.getCollections

import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class GetCollectionsUseCase @Inject constructor(private val repository: CollectionContract) {
    suspend fun invoke(): List<MonsterCollection> {
        return repository.getCollections()
    }
}