package com.example.dndhandbook.domain.models.collection

import android.os.Parcelable
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.collection.MonsterCollection.Companion.NEW_COLLECTION_ID
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class MonsterCollection(
    var id: Long? = null,
    val name: String = "",
    val monsterList: List<DefaultObject>? = null,
    var date: Date = Date(),
    var modifiedDate: Date = Date(),
) : Parcelable {

    companion object {
        const val NEW_COLLECTION_ID = -1L

        fun newInstance(): MonsterCollection {
            return MonsterCollection(
                id = -1,
                name = "",
                monsterList = emptyList(),
                date = Date(),
                modifiedDate = Date(),
            )
        }
    }

    fun toCollectionEntity(): MonsterCollectionEntity {
        return MonsterCollectionEntity(
            id = id ?: 0L,
            name = name,
            monsterList = monsterList,
            date = date,
            modifiedDate = modifiedDate,
        )
    }

    /**
     * Return new data with correct ID
     *
     * When it's new collection, id == [NEW_COLLECTION_ID], in this case set null on id (id is set by Room).
     *
     * else, return the same data
     */
    fun setupCollectionId(): MonsterCollection {
        return when {
            isNewCollection() -> copy(id = null)
            else -> copy()
        }
    }
}

fun MonsterCollection.isNewCollection(): Boolean = id == null || id == NEW_COLLECTION_ID

fun Long?.isNewCollection(): Boolean = this == null || this == NEW_COLLECTION_ID