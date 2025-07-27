package com.example.dndhandbook.data.repository.collection

import com.example.dndhandbook.data.local.database.CollectionsDao
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class CollectionRepository @Inject constructor(
    private val collectionsDao: CollectionsDao,
) : CollectionContract {

    override suspend fun saveCollection(collection: MonsterCollection): Long? {
        return collectionsDao.insertCollection(collection.toCollectionEntity())
    }

    override suspend fun getCollections(): List<MonsterCollection> {
        return collectionsDao.getCollections().map { it.toCollection() }
    }

    override suspend fun getCollection(id: Long): MonsterCollection? {
        return collectionsDao.getCollection(id).toCollection()
    }

    override suspend fun deleteCollection(id: Long?) {
        id?.let { collectionsDao.deleteCollection(it) }
    }

    override suspend fun clearCollection() {

    }
}