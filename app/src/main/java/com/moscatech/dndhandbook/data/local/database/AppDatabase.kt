package com.moscatech.dndhandbook.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.moscatech.dndhandbook.domain.models.BestiaryEntity
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollectionEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

@Database(
    entities = [MonsterCollectionEntity::class, BestiaryEntity::class],
    version = 1,
)
@TypeConverters(DateConverter::class, ListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun collectionDao(): CollectionsDao
    abstract fun bestiaryDao(): BestiaryDao
}

class ListConverter {

    @TypeConverter
    fun fromDefaultObjectList(list: List<DefaultObject>?): String? {
        if (list.isNullOrEmpty()) return null

        val type = object : TypeToken<List<DefaultObject?>?>() {}.type
        val json: String = Gson().toJson(list, type)

        return json
    }

    @TypeConverter
    fun toDefaultObjectList(sourceList: String?): List<DefaultObject>? {
        if (sourceList == null) return null

        val type = object : TypeToken<List<DefaultObject?>?>() {}.type
        val list: List<DefaultObject> = Gson().fromJson(sourceList, type)

        return list
    }
}

class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return if (dateLong != null) Date(dateLong) else null
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}