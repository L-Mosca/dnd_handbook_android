package com.moscatech.dndhandbook.domain.models.collection

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.moscatech.dndhandbook.data.local.database.DateConverter
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import java.util.Date

@Entity(tableName = "collection_table")
data class MonsterCollectionEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Long = 0,
    @ColumnInfo("name") val name: String = "",
    @ColumnInfo("monster_list") val monsterList: List<DefaultObject>? = null,
    @ColumnInfo(name = "create_date") @TypeConverters(DateConverter::class) var date: Date = Date(),
    @ColumnInfo(name = "modified_date") @TypeConverters(DateConverter::class) var modifiedDate: Date = Date(),
) {
    fun toCollection(): MonsterCollection {
        return MonsterCollection(
            id = id,
            name = name,
            monsterList = monsterList,
            date = date,
            modifiedDate = modifiedDate,
        )
    }
}