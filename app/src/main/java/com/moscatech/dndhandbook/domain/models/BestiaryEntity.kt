package com.moscatech.dndhandbook.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moscatech.dndhandbook.domain.models.base.DefaultList
import com.moscatech.dndhandbook.domain.models.base.DefaultObject

@Entity(tableName = "bestiary_table")
data class BestiaryEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("count") val count: Int = 0,
    @ColumnInfo("results") val results: List<DefaultObject> = emptyList(),
) {

    fun toDefaultList(): DefaultList = DefaultList(count = count, results = results)
}