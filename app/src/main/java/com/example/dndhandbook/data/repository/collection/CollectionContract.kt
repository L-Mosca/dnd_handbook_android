package com.example.dndhandbook.data.repository.collection

import com.example.dndhandbook.domain.models.collection.MonsterCollection

interface CollectionContract {
    suspend fun saveCollection(collection: MonsterCollection): Long?
    suspend fun getCollections(): List<MonsterCollection>
    suspend fun getCollection(id: Long): MonsterCollection?
    suspend fun deleteCollection(id: Long?)
    suspend fun clearCollection()
}