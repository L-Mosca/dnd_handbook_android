package com.example.dndhandbook.domain.models.collection

import android.os.Parcelable
import com.example.dndhandbook.domain.models.base.DefaultObject
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class MonsterCollection(
    val name: String = "",
    val monsterList: List<DefaultObject> = emptyList(),
) : Parcelable