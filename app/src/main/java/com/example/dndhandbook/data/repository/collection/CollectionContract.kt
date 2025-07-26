package com.example.dndhandbook.data.repository.collection

import com.example.dndhandbook.domain.models.collection.MonsterCollection

interface CollectionContract {
    suspend fun saveCollection(collection: MonsterCollection)
    suspend fun getCollections(): List<MonsterCollection>
    suspend fun getCollection(collectionName: String): MonsterCollection?
    suspend fun deleteCollection(collection: MonsterCollection)
    suspend fun clearCollection()
}