package com.moscatech.dndhandbook.domain.useCase.collection.getCollection

import com.moscatech.dndhandbook.data.repository.collection.CollectionContract
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class GetCollectionUseCase @Inject constructor(private val repository: CollectionContract) {

    suspend fun invoke(id: Long?): MonsterCollection? {
        if (id == null) return null
        val collection = repository.getCollection(id)
        return collection?.copy(
            monsterList = collection.monsterList?.sortedBy { it.name }
        )
    }
}