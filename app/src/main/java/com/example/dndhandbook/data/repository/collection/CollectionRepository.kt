package com.example.dndhandbook.data.repository.collection

import com.example.dndhandbook.data.local.database.CollectionsDao
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class CollectionRepository @Inject constructor(
    private val collectionsDao: CollectionsDao,
) : CollectionContract {

    override suspend fun saveCollection(collection: MonsterCollection): Int? {
        collectionsDao.insertCollection(collection.toCollectionEntity())
        return 1
    }

    override suspend fun getCollections(): List<MonsterCollection> {
        return collectionsDao.getCollections().map { it.toCollection() }
    }

    override suspend fun getCollection(id: Int): MonsterCollection? {
        return collectionsDao.getCollection(id).toCollection()
    }

    override suspend fun deleteCollection(collection: MonsterCollection) {
        collection.id?.let { collectionsDao.deleteCollection(it) }
    }

    override suspend fun clearCollection() {

    }
}