package com.example.dndhandbook.data.local

import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.collection.MonsterCollection

interface PreferencesContract {

    suspend fun saveMonsterDetail(monster: DefaultObject?)
    suspend fun getMonsterDetail(): DefaultObject?
    suspend fun clearMonsterDetail()

    suspend fun saveCollection(collection: MonsterCollection)
    suspend fun getCollections(): List<MonsterCollection>
    suspend fun deleteCollection(collection: MonsterCollection)
    suspend fun clearCollections()
}