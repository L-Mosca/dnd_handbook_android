package com.example.dndhandbook.domain.useCase.collection.getCollection

import com.example.dndhandbook.data.repository.collection.CollectionContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class GetCollectionUseCase @Inject constructor(private val repository: CollectionContract) {

    suspend fun invoke(id: Long?): MonsterCollection? {
        if (id == null) return null

        return repository.getCollection(id)
    }
}