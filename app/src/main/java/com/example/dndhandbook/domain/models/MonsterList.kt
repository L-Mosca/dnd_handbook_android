package com.example.dndhandbook.domain.models

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.MonsterBasicDataDto
import com.example.dndhandbook.data.remote.dto.MonsterListDto
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterList(
    val count: Int = 0,
    val results: List<MonsterBasicData> = emptyList(),
) : Parcelable

fun MonsterListDto.toMonsterList(): MonsterList = MonsterList(
    count = count,
    results = results.toMonsterBasicDataList()
)

fun List<MonsterBasicDataDto>.toMonsterBasicDataList(): List<MonsterBasicData> {
    val list = mutableListOf<MonsterBasicData>()
    forEach {
        list.add(it.toMonsterBasicData())
    }
    return list
}