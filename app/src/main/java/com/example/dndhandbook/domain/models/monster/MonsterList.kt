package com.example.dndhandbook.domain.models.monster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterList(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<MonsterBasicData> = emptyList(),
) : Parcelable