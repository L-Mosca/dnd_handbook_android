package com.example.dndhandbook.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dndhandbook.domain.models.base.DefaultObject

@Entity(tableName = "bestiary_table")
data class BestiaryEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("count") val count: Int = 0,
    @ColumnInfo("results") val results: List<DefaultObject> = emptyList(),
)