package com.example.dndhandbook.domain.models.collection

import android.os.Parcelable
import com.example.dndhandbook.domain.models.base.DefaultObject
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterCollection(
    val name: String = "",
    val monsterList: List<DefaultObject> = emptyList(),
) : Parcelable