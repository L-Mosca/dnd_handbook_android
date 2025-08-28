package com.moscatech.dndhandbook.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollectionEntity

@Dao
interface CollectionsDao {

    @Query("SELECT * FROM collection_table")
    suspend fun getCollections(): List<MonsterCollectionEntity>

    @Query("SELECT * FROM collection_table WHERE id = :id")
    suspend fun getCollection(id: Long): MonsterCollectionEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: MonsterCollectionEntity): Long?

    @Update
    suspend fun updateCollection(collection: MonsterCollectionEntity)

    @Query("DELETE FROM collection_table WHERE id = :id")
    suspend fun deleteCollection(id: Long)
}