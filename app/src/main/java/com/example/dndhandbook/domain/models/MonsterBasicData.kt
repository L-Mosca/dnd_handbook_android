package com.example.dndhandbook.domain.models

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.MonsterBasicDataDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterBasicData(
    val index: String = "",
    val name: String = "",
    val url: String = "",
) : Parcelable

fun MonsterBasicDataDto.toMonsterBasicData(): MonsterBasicData = MonsterBasicData(
    index = index,
    name = name,
    url = url
)