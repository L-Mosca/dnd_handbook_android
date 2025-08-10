package com.example.dndhandbook.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dndhandbook.domain.models.BestiaryEntity

@Dao
interface BestiaryDao {
    @Query("SELECT * FROM bestiary_table")
    suspend fun getBestiary(): BestiaryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBestiary(bestiary: BestiaryEntity)

    @Query("DELETE FROM bestiary_table")
    suspend fun clear()
}