package com.example.dndhandbook.domain.models.monster

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.monster.MonsterListDto
import com.example.dndhandbook.domain.models.base.DefaultObject
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterList(
    val count: Int = 0,
    val results: List<DefaultObject> = emptyList(),
) : Parcelable

fun MonsterListDto.toMonsterList(): MonsterList = MonsterList(count = count, results = results)