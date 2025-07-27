package com.example.dndhandbook.domain.models.collection

import android.os.Parcelable
import com.example.dndhandbook.domain.models.base.DefaultObject
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class MonsterCollection(
    var id: Int? = null,
    val name: String = "",
    val monsterList: List<DefaultObject> = emptyList(),
    var date: Date = Date(),
    var modifiedDate: Date = Date(),
) : Parcelable {

    fun toCollectionEntity(): MonsterCollectionEntity {
        return MonsterCollectionEntity(
            id = id ?: 0,
            name = name,
            monsterList = monsterList,
            date = date,
            modifiedDate = modifiedDate,
        )
    }
}