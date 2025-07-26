package com.example.dndhandbook.data.repository.collection

import com.example.dndhandbook.data.local.PreferencesContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import javax.inject.Inject

class CollectionRepository @Inject constructor(
    private val preferencesHelper: PreferencesContract
) : CollectionContract {

    override suspend fun saveCollection(collection: MonsterCollection) {
        preferencesHelper.saveCollection(collection)
    }

    override suspend fun getCollections(): List<MonsterCollection> {
        return preferencesHelper.getCollections()
    }

    override suspend fun getCollection(collectionName: String): MonsterCollection? {
        return preferencesHelper.getCollection(collectionName)
    }

    override suspend fun deleteCollection(collection: MonsterCollection) {
        preferencesHelper.deleteCollection(collection)
    }

    override suspend fun clearCollection() {
        preferencesHelper.clearCollections()
    }
}