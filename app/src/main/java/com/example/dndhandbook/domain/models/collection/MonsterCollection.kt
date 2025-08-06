package com.example.dndhandbook.domain.models.collection

import android.os.Parcelable
import com.example.dndhandbook.domain.models.base.DefaultObject
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

    fun isEmpty(): Boolean {
        return name.isBlank() && monsterList.isNullOrEmpty()
    }
}